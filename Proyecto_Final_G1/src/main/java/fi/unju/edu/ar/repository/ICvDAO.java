package fi.unju.edu.ar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Cv;

@Repository
public interface ICvDAO extends CrudRepository<Cv,  Long > {

}
