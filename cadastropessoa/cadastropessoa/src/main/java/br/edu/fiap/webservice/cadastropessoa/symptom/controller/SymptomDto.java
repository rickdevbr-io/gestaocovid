package br.edu.fiap.webservice.cadastropessoa.symptom.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SymptomDto {

	private Long id;

	private String description;
	
	private Date createdDate;
}
