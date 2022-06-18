package fi.unju.edu.ar.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fi.unju.edu.ar.entity.Empresa;

public interface IUsuarioERepository extends CrudRepository<Empresa,Long> {

    public Optional<Empresa> findByCuit (Long cuit);

}