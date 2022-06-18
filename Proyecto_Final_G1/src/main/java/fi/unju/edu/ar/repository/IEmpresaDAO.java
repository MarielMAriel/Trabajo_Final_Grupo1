package fi.unju.edu.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Empresa;
@Repository
public interface IEmpresaDAO extends JpaRepository<Empresa, Long >{

	public Empresa findByCuitAndContrasenia(String cuit, String contrasenia);
}
