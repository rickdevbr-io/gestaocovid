package br.edu.fiap.webservice.cadastropessoa.region.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionDto {

	private Long id;

	private String description;
	
	private Date createdDate;
}
