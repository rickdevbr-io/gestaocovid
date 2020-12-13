package br.edu.fiap.webservice.cadastropessoa.person.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Long> , JpaSpecificationExecutor<Person>{

	List<Person> findAll();
	
	Person findByIdentification(String identification);
}
