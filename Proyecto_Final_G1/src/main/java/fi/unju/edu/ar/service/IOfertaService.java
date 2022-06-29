package fi.unju.edu.ar.service;

import java.util.List;

import fi.unju.edu.ar.entity.OfertaLab;

public interface IOfertaService {
	public void guardar(OfertaLab oferta);
	public OfertaLab getOferta();
	public List<OfertaLab>getlistaOfertaLab();
}
