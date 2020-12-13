package br.edu.fiap.webservice.cadastropessoa.person.controller;

import java.util.Date;
import java.util.List;

import br.edu.fiap.webservice.cadastropessoa.region.controller.RegionDto;
import br.edu.fiap.webservice.cadastropessoa.symptom.controller.SymptomDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonRegistrationDto {

	private Long id;
	
	private String name;
	
	private String identification;
	
	private String gender;
	
	private Date born;
	
	private Date createdDate;
	
	private RegionDto region;
	
	private List<SymptomDto> Symptoms;
	
}
