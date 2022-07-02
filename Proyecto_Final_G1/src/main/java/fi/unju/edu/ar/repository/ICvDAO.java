package fi.unju.edu.ar.repository;

import org.springframework.data.repository.CrudRepository;

import fi.unju.edu.ar.entity.Cv;
/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
*para la entidad  Cv que tiene una clave primaria valores Long.
*y que crea un metodo de busqueda de codigo de producucto(Cv)
*/  

public interface ICvDAO extends CrudRepository<Cv,  Long > {

}
