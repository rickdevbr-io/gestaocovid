package br.edu.fiap.webservice.cadastropessoa.symptom.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fiap.webservice.cadastropessoa.symptom.model.ISymptomPersonRepository;
import br.edu.fiap.webservice.cadastropessoa.symptom.model.ISymptomRepository;
import br.edu.fiap.webservice.cadastropessoa.symptom.model.Symptom;
import br.edu.fiap.webservice.cadastropessoa.symptom.model.SymptomPerson;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SymptomService {

	private final ISymptomRepository symptomRepository;
	private final ISymptomPersonRepository symptomPersonRepository;
	
	public List<Symptom> loadSymptoms(){
		return symptomRepository.findAll();
	}
	
	public Symptom findSymptomById(Long id){
		if(Objects.isNull(id))
			this.loadSymptoms();
		
		Optional<Symptom> symptom = symptomRepository.findById(id);
		
		if(symptom.isEmpty())
			return new Symptom();
		
		return symptom.get();

	}
	
	public Symptom save(Symptom symptom) {
		return symptomRepository.save(symptom);
	}
	
	public void delete(Long id) {
		symptomRepository.deleteById(id);
	}
	
	public List<SymptomPerson> findSymptomsPerson(Long idPerson) {
		return symptomPersonRepository.findAllByIdPerson(idPerson);
	}
	
	public SymptomPerson saveSymptomPerson(SymptomPerson symptomPerson) {
		return symptomPersonRepository.save(symptomPerson);
	}
	
	public void deleteSymptomPerson(Long idPerson) {
		List<SymptomPerson> symptomsPerson = symptomPersonRepository.findAllByIdPerson(idPerson); 
		symptomPersonRepository.deleteAll(symptomsPerson);
	}
}
