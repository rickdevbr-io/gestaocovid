package br.edu.fiap.webservice.cadastropessoa.person.controller;

import java.util.Objects;

import br.edu.fiap.webservice.cadastropessoa.person.model.Person;

public class PersonMapper {
	
	public static PersonDto entityToPersonDto(Person entity) {
		if(Objects.isNull(entity))
			return new PersonDto();
		
		return PersonDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.identification(entity.getIdentification())
				.gender(entity.getGender())
				.born(entity.getBorn())
				.createdDate(entity.getCreatedDate())
				.idRegion(entity.getIdRegion())
				.build();
	}
	
	public static Person dtoToPerson(PersonDto dto) {
		if(Objects.isNull(dto))
			return new Person();
		
		return Person.builder()
				.id(dto.getId())
				.name(dto.getName())
				.identification(dto.getIdentification())
				.gender(dto.getGender())
				.born(dto.getBorn())
				.createdDate(dto.getCreatedDate())
				.idRegion(dto.getIdRegion())
				.build();
	}
	
	public static PersonRegistrationDto personDtoToPersonRegistrationDto(PersonDto personDto) {
		if(Objects.isNull(personDto))
			return new PersonRegistrationDto();
		
		return PersonRegistrationDto.builder()
				.id(personDto.getId())
				.name(personDto.getName())
				.identification(personDto.getIdentification())
				.gender(personDto.getGender())
				.born(personDto.getBorn())
				.createdDate(personDto.getCreatedDate())
				.build();
	}

	public static PersonDto personRegistrationDtoToPersonDto(PersonRegistrationDto personRegistrationDto) {
		if(Objects.isNull(personRegistrationDto))
			return new PersonDto();
		
		return PersonDto.builder()
				.id(personRegistrationDto.getId())
				.name(personRegistrationDto.getName())
				.identification(personRegistrationDto.getIdentification())
				.gender(personRegistrationDto.getGender())
				.born(personRegistrationDto.getBorn())
				.idRegion(personRegistrationDto.getRegion().getId())
				.createdDate(personRegistrationDto.getCreatedDate())				
				.build();
	}
}
