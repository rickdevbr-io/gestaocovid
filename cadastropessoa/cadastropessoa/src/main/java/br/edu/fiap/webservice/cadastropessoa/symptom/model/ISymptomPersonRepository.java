package br.edu.fiap.webservice.cadastropessoa.symptom.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISymptomPersonRepository extends CrudRepository<SymptomPerson, Long>, JpaSpecificationExecutor<SymptomPerson>{

	List<SymptomPerson> findAllByIdPerson(Long id);
	
}
