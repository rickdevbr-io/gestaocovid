package br.edu.fiap.webservice.gestaocovid.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Long> , JpaSpecificationExecutor<Person>{
	
	@Query("Select count(pers.idRegion) as qtde, regi.description as region"
			+ " from Person pers"
			+ "	inner join Region regi on pers.idRegion = regi.id"
			+ " where pers.idRegion is not null"
			+ " group by pers.idRegion, regi.description"
			+ " order by qtde desc ")
	public List<INeedyRegion> findNeedyRegion();
}
