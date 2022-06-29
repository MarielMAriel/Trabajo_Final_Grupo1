package fi.unju.edu.ar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.entity.OfertaLab;

public interface IOfertaDao extends JpaRepository<OfertaLab, Long>{
	@Query("from OfertaLab e order by e.puestoReq")
	public List<OfertaLab> ofertasEmpr();
}
