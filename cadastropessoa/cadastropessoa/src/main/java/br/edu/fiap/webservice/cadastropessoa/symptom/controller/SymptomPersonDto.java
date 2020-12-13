package br.edu.fiap.webservice.cadastropessoa.symptom.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SymptomPersonDto {
	
	private Long id;

	private Long idPerson;
	
	private Long idSymptom;
	
	private Date createdDate;
}
