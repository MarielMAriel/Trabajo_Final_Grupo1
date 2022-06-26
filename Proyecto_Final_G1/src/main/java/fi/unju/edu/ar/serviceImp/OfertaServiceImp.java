package fi.unju.edu.ar.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.OfertaLab;
import fi.unju.edu.ar.repository.IOfertaDao;
import fi.unju.edu.ar.service.IOfertaService;

@Service
public class OfertaServiceImp implements IOfertaService{
	@Autowired
	private IOfertaDao ofertaDao;

	@Override
	public OfertaLab getOferta() {
		// TODO Auto-generated method stub
		return new OfertaLab();
	}

	@Override
	public void guardar(OfertaLab oferta) {
		// TODO Auto-generated method stub
		ofertaDao.save(oferta);
		
	}

}
