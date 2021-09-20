package br.com.asty.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.asty.springdata.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer>{
    
}
