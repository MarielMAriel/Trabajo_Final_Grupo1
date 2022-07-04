package fi.unju.edu.ar.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Institucion;
import fi.unju.edu.ar.repository.InstitucionDao;
import fi.unju.edu.ar.service.InstitucionService;

@Service
public class InstitucionServiceImp implements InstitucionService{
	@Autowired
	InstitucionDao institucionDao;
	
	
	@Override
	public Institucion nuevoInstitucion() {
		// TODO Auto-generated method stub
		return new Institucion();
	}


	@Override
	public void guardar(Institucion institucion) {
		// TODO Auto-generated method stub
		institucionDao.save(institucion);
		
	}


	@Override
	public Institucion buscarInstitucion(String cuit) {
		// TODO Auto-generated method stub
		return institucionDao.findByCuit(cuit).get();
	}

}
