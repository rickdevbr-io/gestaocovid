package br.edu.fiap.webservice.gestaocovid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fiap.webservice.gestaocovid.service.RegionManagmentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/gestao-covid")
public class RegionManagmentController {

	private final RegionManagmentService regionManagmentService;
	
	@GetMapping("/regiao/necessita-sangue")
	public NeedyRegionDto findNeedyRegion(){
		return RegionManagmentMapper.interfaceToNeedyRegionDto(regionManagmentService.findNeedyRegion());
	}
}
