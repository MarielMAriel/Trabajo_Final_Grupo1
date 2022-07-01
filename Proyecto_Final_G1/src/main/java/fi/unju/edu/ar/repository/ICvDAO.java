package fi.unju.edu.ar.repository;

import org.springframework.data.repository.CrudRepository;

import fi.unju.edu.ar.entity.Cv;


public interface ICvDAO extends CrudRepository<Cv,  Long > {

}
