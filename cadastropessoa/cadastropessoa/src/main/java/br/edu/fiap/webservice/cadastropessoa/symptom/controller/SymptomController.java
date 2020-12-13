package br.edu.fiap.webservice.cadastropessoa.symptom.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fiap.webservice.cadastropessoa.symptom.service.SymptomService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sintoma")
public class SymptomController {

	private final SymptomService symptomService; 
	
	@GetMapping("/listar")
	public List<SymptomDto> loadSymptoms(){
		return symptomService.loadSymptoms()
				.stream()
				.map(SymptomMapper :: entityToSymptomDto)
				.collect(Collectors.toList());
				
	}
	
	@GetMapping("/{id}")
	public SymptomDto findSymptomById(@PathVariable("id") Long id) {
		return SymptomMapper.entityToSymptomDto(
				symptomService.findSymptomById(id)
				);
	}
	
	@PostMapping("/registrar")
	public SymptomDto save(@RequestBody(required = false) SymptomDto regionDto ) {
		return SymptomMapper.entityToSymptomDto(
				symptomService.save(
						SymptomMapper.dtoToSymptom(regionDto)
						)
				);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSymptomById(@PathVariable("id") Long id) {
		symptomService.delete(id);
	}
	
}
