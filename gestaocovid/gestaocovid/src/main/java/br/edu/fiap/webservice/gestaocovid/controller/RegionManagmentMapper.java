package br.edu.fiap.webservice.gestaocovid.controller;

import java.util.Objects;

import br.edu.fiap.webservice.gestaocovid.model.INeedyRegion;

public class RegionManagmentMapper {

	public static NeedyRegionDto interfaceToNeedyRegionDto (INeedyRegion entity) {
		if(Objects.isNull(entity))
			return new NeedyRegionDto();
		
		return NeedyRegionDto.builder()
				.qtde(entity.getQtde())
				.region(entity.getRegion())
				.build();
	}
	
}
