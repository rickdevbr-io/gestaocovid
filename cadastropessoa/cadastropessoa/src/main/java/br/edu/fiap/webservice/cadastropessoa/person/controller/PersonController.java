package br.edu.fiap.webservice.cadastropessoa.person.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fiap.webservice.cadastropessoa.facade.PersonRegistrationFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoa")
public class PersonController {

	private final PersonRegistrationFacade personRegistrationFacade; 
	
	@GetMapping("/listar")
	public List<PersonRegistrationDto> loadPeople(){
		return personRegistrationFacade.loadPeople();
	}
	
	@GetMapping("/{cpf}")
	public PersonRegistrationDto findPersonByIdentification(@PathVariable("cpf") String identification) {
		return personRegistrationFacade.findPersonByIdentification(identification);
	}
	
	@PostMapping("/registrar")
	public PersonRegistrationDto save(@RequestBody(required = false) PersonRegistrationDto personRegistrationDto ) {
		return personRegistrationFacade.save(personRegistrationDto);
	}
	
	@DeleteMapping("/{cpf}")
	public void delete(@PathVariable("cpf") String identification) {
		personRegistrationFacade.delete(identification);
	}
	
}
