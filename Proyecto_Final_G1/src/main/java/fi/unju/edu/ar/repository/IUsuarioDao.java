package fi.unju.edu.ar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findById(String id);
	

}
