package br.edu.fiap.webservice.gestaocovid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.fiap.webservice.gestaocovid.model.INeedyRegion;
import br.edu.fiap.webservice.gestaocovid.model.IPersonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegionManagmentService {

	private final IPersonRepository personRepository;
	
	public INeedyRegion findNeedyRegion(){
		List<INeedyRegion> result = personRepository.findNeedyRegion();
		
		if(result.size() == 0)
			return null;
		
		return result.get(0);
	}
}
