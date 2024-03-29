package fi.unju.edu.ar.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Usuario;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	public Optional<Usuario> findByIdentificador(String identificador);
	

}
