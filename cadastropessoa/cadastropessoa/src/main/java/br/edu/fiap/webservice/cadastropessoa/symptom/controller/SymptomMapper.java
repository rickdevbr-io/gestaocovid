package br.edu.fiap.webservice.cadastropessoa.symptom.controller;

import java.util.Objects;

import br.edu.fiap.webservice.cadastropessoa.symptom.model.Symptom;
import br.edu.fiap.webservice.cadastropessoa.symptom.model.SymptomPerson;

public class SymptomMapper {
	
	public static SymptomDto entityToSymptomDto(Symptom entity) {
		if(Objects.isNull(entity))
			return new SymptomDto();
		
		return SymptomDto.builder()
				.id(entity.getId())
				.description(entity.getDescription())
				.createdDate(entity.getCreatedDate())
				.build();
	}
	
	public static Symptom dtoToSymptom(SymptomDto dto) {
		if(Objects.isNull(dto))
			return new Symptom();
		
		return Symptom.builder()
				.id(dto.getId())
				.description(dto.getDescription())
				.createdDate(dto.getCreatedDate())
				.build();
	}

	public static SymptomPersonDto entityToSymptomPersonDto(SymptomPerson entity) {
		if(Objects.isNull(entity))
			return new SymptomPersonDto();
		
		return SymptomPersonDto.builder()
				.id(entity.getId())
				.idPerson(entity.getIdPerson())
				.idSymptom(entity.getIdSymptom())
				.createdDate(entity.getCreatedDate())
				.build();
	}
	
	public static SymptomPerson dtoToSymptomPerson(SymptomPersonDto dto) {
		if(Objects.isNull(dto))
			return new SymptomPerson();
		
		return SymptomPerson.builder()
				.id(dto.getId())
				.idPerson(dto.getIdPerson())
				.idSymptom(dto.getIdSymptom())
				.createdDate(dto.getCreatedDate())
				.build();
	}
	
}
