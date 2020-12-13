package br.edu.fiap.webservice.cadastropessoa.person.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import br.edu.fiap.webservice.cadastropessoa.person.model.IPersonRepository;
import br.edu.fiap.webservice.cadastropessoa.person.model.Person;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonService {

	private final IPersonRepository personRepository;
	
	public List<Person> loadPeople(){
		return personRepository.findAll();
	}
	
	public Person findPersonByIdentification(String identification){
		if(Objects.isNull(identification))
			this.loadPeople();
		
		Person person = personRepository.findByIdentification(identification);
		
		if(Objects.isNull(person))
			return new Person();
		
		return person;

	}
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public void delete(Long id) {
		personRepository.deleteById(id);
	}
}
