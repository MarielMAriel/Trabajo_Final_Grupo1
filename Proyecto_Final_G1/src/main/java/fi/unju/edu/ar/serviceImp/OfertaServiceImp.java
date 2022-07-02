package fi.unju.edu.ar.serviceImp;


import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.OfertaLab;
import fi.unju.edu.ar.repository.IOfertaDao;
import fi.unju.edu.ar.service.IOfertaService;

@Service
public class OfertaServiceImp implements IOfertaService{
	private static final Log LOGGER = LogFactory.getLog(LoginServiceImp.class);
	@Autowired
	private IOfertaDao ofertaDao;

	@Override
	public OfertaLab getOferta() {
		// TODO Auto-generated method stub
		LOGGER.info("Se devuele una instancia de Oferta Laboral ");
		return new OfertaLab();
	}

	@Override
	public void guardar(OfertaLab oferta) {
		// TODO Auto-generated method stub
		LOGGER.info("Se guarda oferta "+oferta);
		ofertaDao.save(oferta);
	}

	@Override
	public List<OfertaLab> getlistaOfertaLab() {
		// TODO Auto-generated method stub
		LOGGER.info("Se devuele una l ");
		return ofertaDao.ofertasEmpr();
	}

	@Override
	public Optional<OfertaLab> buscarOferta(Long id) {
		// TODO Auto-generated method stub
		LOGGER.info("Se devuele una instancia de un nuevo Usuario "+id);
		return ofertaDao.findById(id);
	}

	@Override
	public void modificarOferta(OfertaLab oferta) {
		List<OfertaLab> ofertas=ofertaDao.ofertasEmpr();
		for (OfertaLab ofertaLab : ofertas) {
			if(ofertaLab.getId().equals(oferta.getId())) {
				ofertaLab=oferta;
			}
		}
		for (OfertaLab ofertaLab : ofertas) {
			ofertaDao.save(ofertaLab);
		}
		LOGGER.info("se modifican la oferta laboral seleccionada");
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		LOGGER.info("se elimino la oferta con el id "+id);
		ofertaDao.deleteById(id);
	}




}
