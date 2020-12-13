package br.edu.fiap.webservice.gestaocovid.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NeedyRegionDto {

	private Long qtde;
	
	private String region;
}
