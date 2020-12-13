package br.edu.fiap.webservice.cadastropessoa.region.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegionRepository extends CrudRepository<Region, Long>, JpaSpecificationExecutor<Region>{

	List<Region> findAll();
}
