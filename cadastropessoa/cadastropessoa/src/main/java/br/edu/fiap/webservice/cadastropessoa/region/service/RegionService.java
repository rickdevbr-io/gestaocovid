package br.edu.fiap.webservice.cadastropessoa.region.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fiap.webservice.cadastropessoa.region.model.IRegionRepository;
import br.edu.fiap.webservice.cadastropessoa.region.model.Region;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionService {
	
	private final IRegionRepository regionRepository; 

	public List<Region> loadRegions(){
		return regionRepository.findAll();
	}
	
	public Region findRegionById(Long id) {
		if(Objects.isNull(id))
			this.loadRegions();
		
		Optional<Region> region = regionRepository.findById(id);
		
		if(region.isEmpty())
			return new Region();
		
		return region.get();

	}
	
	public Region save(Region region) {
		return regionRepository.save(region);
	}
	
	public void delete(Long id) {
		regionRepository.deleteById(id);
	}
}
