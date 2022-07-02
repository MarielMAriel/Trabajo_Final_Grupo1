package fi.unju.edu.ar.serviceImp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Cv;
import fi.unju.edu.ar.repository.ICvDAO;
import fi.unju.edu.ar.service.ICvService;

@Service
public class CvServiceImp implements ICvService {
	
	private static final Log LOGGER = LogFactory.getLog(LoginServiceImp.class);
	
@Autowired ICvDAO cvDao;

@Override
public void guardar(Cv curriculum) {
	LOGGER.info("Se Guardo Cv en la BD "+curriculum);
	
	 cvDao.save(curriculum);
}


}
