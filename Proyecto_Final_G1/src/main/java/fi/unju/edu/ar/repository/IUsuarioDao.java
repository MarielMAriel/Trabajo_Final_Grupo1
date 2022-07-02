package fi.unju.edu.ar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Usuario;

@Repository
/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
 *para la entidad  Usuario que tiene una clave primaria valores Long.
 *y que crea un metodo de busqueda de codigo de producucto(Usuario)
 */  
public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	public Optional<Usuario> findByIdentificador(String identificador);
	

}
