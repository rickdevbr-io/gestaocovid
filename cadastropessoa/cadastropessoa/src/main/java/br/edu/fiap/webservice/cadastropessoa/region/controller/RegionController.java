package br.edu.fiap.webservice.cadastropessoa.region.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fiap.webservice.cadastropessoa.region.service.RegionService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/regiao")
public class RegionController {

	private final RegionService regionService; 
	
	@GetMapping("/listar")
	public List<RegionDto> loadRegions(){
		return regionService.loadRegions()
				.stream()
				.map(RegionMapper :: entityToRegionDto)
				.collect(Collectors.toList());
				
	}
	
	@GetMapping("/{id}")
	public RegionDto findRegionById(@PathVariable("id") Long id) {
		return RegionMapper.entityToRegionDto(
				regionService.findRegionById(id)
				);
	}
	
	@PostMapping("/registrar")
	public RegionDto save(@RequestBody(required = false) RegionDto regionDto ) {
		return RegionMapper.entityToRegionDto(
				regionService.save(
						RegionMapper.dtoToRegion(regionDto)
						)
				);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRegionById(@PathVariable("id") Long id) {
		regionService.delete(id);
	}
	
}
