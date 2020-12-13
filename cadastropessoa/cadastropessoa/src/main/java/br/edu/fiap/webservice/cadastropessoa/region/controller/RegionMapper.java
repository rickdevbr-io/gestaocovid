package br.edu.fiap.webservice.cadastropessoa.region.controller;

import java.util.Objects;

import br.edu.fiap.webservice.cadastropessoa.region.model.Region;

public class RegionMapper {
	
	public static RegionDto entityToRegionDto(Region entity) {
		if(Objects.isNull(entity))
			return new RegionDto();
		
		return RegionDto.builder()
				.id(entity.getId())
				.description(entity.getDescription())
				.createdDate(entity.getCreatedDate())
				.build();
	}
	
	public static Region dtoToRegion(RegionDto dto) {
		if(Objects.isNull(dto))
			return new Region();
		
		return Region.builder()
				.id(dto.getId())
				.description(dto.getDescription())
				.createdDate(dto.getCreatedDate())
				.build();
	}

}
