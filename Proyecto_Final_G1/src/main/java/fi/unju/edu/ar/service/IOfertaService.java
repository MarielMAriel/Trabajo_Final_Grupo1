package fi.unju.edu.ar.service;

import java.util.List;
import java.util.Optional;

import fi.unju.edu.ar.entity.OfertaLab;

public interface IOfertaService {
	public void guardar(OfertaLab oferta);
	public OfertaLab getOferta();
	public List<OfertaLab>getlistaOfertaLab();
	public Optional<OfertaLab> buscarOferta(Long id);
	public void modificarOferta(OfertaLab oferta);
	public void borrar(Long id);
}
