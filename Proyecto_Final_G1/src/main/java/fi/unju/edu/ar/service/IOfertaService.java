package fi.unju.edu.ar.service;

import fi.unju.edu.ar.entity.OfertaLab;

public interface IOfertaService {
	public void guardar(OfertaLab oferta);
	public OfertaLab getOferta();

}
