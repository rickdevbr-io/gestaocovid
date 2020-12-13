package br.edu.fiap.webservice.cadastropessoa.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.edu.fiap.webservice.cadastropessoa.person.controller.PersonDto;
import br.edu.fiap.webservice.cadastropessoa.person.controller.PersonMapper;
import br.edu.fiap.webservice.cadastropessoa.person.controller.PersonRegistrationDto;
import br.edu.fiap.webservice.cadastropessoa.person.service.PersonService;
import br.edu.fiap.webservice.cadastropessoa.region.controller.RegionDto;
import br.edu.fiap.webservice.cadastropessoa.region.controller.RegionMapper;
import br.edu.fiap.webservice.cadastropessoa.region.service.RegionService;
import br.edu.fiap.webservice.cadastropessoa.symptom.controller.SymptomDto;
import br.edu.fiap.webservice.cadastropessoa.symptom.controller.SymptomMapper;
import br.edu.fiap.webservice.cadastropessoa.symptom.controller.SymptomPersonDto;
import br.edu.fiap.webservice.cadastropessoa.symptom.service.SymptomService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonRegistrationFacade {
	
	private final PersonService personService;
	private final RegionService regionService;
	private final SymptomService symptomService;
	
	public List<PersonRegistrationDto> loadPeople(){
		List<PersonDto> personDtos = personService.loadPeople().stream()
				.map(PersonMapper :: entityToPersonDto)
				.collect(Collectors.toList());
		
		if(personDtos.size() == 0)
			return new ArrayList<PersonRegistrationDto>();
		
		List<PersonRegistrationDto> personRegistrationDtos = new ArrayList<PersonRegistrationDto>();
		for(PersonDto person : personDtos) {
			PersonRegistrationDto personRegistrationDto = PersonMapper.personDtoToPersonRegistrationDto(person);
			personRegistrationDto.setRegion(this.loadRegionPerson(person.getIdRegion()));			
			personRegistrationDto.setSymptoms(this.loadSymptomsPerson(person.getId()));
			personRegistrationDtos.add(personRegistrationDto);
		}
		
		return personRegistrationDtos;
	}
	
	public PersonRegistrationDto findPersonByIdentification(String identification) {
		PersonDto personDto = PersonMapper.entityToPersonDto(
				personService.findPersonByIdentification(identification)
				);
		
		if(Objects.isNull(personDto.getId()))
			return new PersonRegistrationDto();
		
		PersonRegistrationDto personRegistrationDto = PersonMapper.personDtoToPersonRegistrationDto(personDto);		

		personRegistrationDto.setRegion(this.loadRegionPerson(personDto.getIdRegion()));
		
		personRegistrationDto.setSymptoms(this.loadSymptomsPerson(personRegistrationDto.getId()));
		
		return personRegistrationDto;
			
	}
	
	@Transactional
	public PersonRegistrationDto save(PersonRegistrationDto personRegistrationDto) {

		PersonDto personDto = PersonMapper.personRegistrationDtoToPersonDto(personRegistrationDto);
		 
		personDto = PersonMapper.entityToPersonDto(
				personService.save(PersonMapper.dtoToPerson(personDto))
				);

		personRegistrationDto.setId(personDto.getId());
		
		personRegistrationDto.setRegion(this.loadRegionPerson(personDto.getIdRegion()));
		
		personRegistrationDto.setSymptoms(
				this.updateSymptomsPerson(
						personRegistrationDto.getSymptoms(), 
						personRegistrationDto.getId()
						)
				);
		
		return personRegistrationDto;
	}

	public void delete(String identification) {
		PersonDto personDto = PersonMapper.entityToPersonDto(personService.findPersonByIdentification(identification));
		
		if(!Objects.isNull(personDto)) {
			symptomService.deleteSymptomPerson(personDto.getId());
			personService.delete(personDto.getId());
		}
	}
	
	private List<SymptomDto> loadSymptomsPerson(Long idPerson){		
		List<SymptomDto> symptomDtos = new ArrayList<SymptomDto>();
		
		List<SymptomPersonDto> symptomPersonDtos = symptomService
				.findSymptomsPerson(idPerson)
				.stream()
				.map(SymptomMapper::entityToSymptomPersonDto)
				.collect(Collectors.toList());
		
		if(symptomPersonDtos.size() > 0) {
			for(SymptomPersonDto dto : symptomPersonDtos) {
				SymptomDto symptomDto =  SymptomMapper.entityToSymptomDto(
						symptomService.findSymptomById(dto.getIdSymptom())
						);
				
				if(!Objects.isNull(symptomDto))
					symptomDtos.add(symptomDto);
			}
		}
		
		return symptomDtos;
	}

	private RegionDto loadRegionPerson(Long idRegion) {
		return RegionMapper.entityToRegionDto(
				regionService.findRegionById(idRegion)
				);
	}
	
	private List<SymptomDto> updateSymptomsPerson(List<SymptomDto> symptoms, Long idPerson) {
		
		symptomService.deleteSymptomPerson(idPerson);
		if(symptoms.size() > 0) {
			for(SymptomDto dto : symptoms) {
				
				SymptomDto symptomDto = SymptomMapper.entityToSymptomDto(
						symptomService.findSymptomById(dto.getId())
						);
				
				if(!Objects.isNull(symptomDto.getId())) {
					SymptomPersonDto symptomPersonDto = SymptomPersonDto.builder()
							.idPerson(idPerson)
							.idSymptom(symptomDto.getId())
							.createdDate(new Date())
							.build();
					
					symptomPersonDto = SymptomMapper.entityToSymptomPersonDto(
							symptomService.saveSymptomPerson(SymptomMapper.dtoToSymptomPerson(symptomPersonDto))
							);
				}
			}
		}
		
		return this.loadSymptomsPerson(idPerson);
	} 

}
