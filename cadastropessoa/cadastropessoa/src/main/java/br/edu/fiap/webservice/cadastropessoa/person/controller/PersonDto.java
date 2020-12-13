package br.edu.fiap.webservice.cadastropessoa.person.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

	private Long id;
	
	private String name;
	
	private String identification;
	
	private String gender;
	
	private Date born;
	
	private Date createdDate;
	
	private Long idRegion;
	
}
