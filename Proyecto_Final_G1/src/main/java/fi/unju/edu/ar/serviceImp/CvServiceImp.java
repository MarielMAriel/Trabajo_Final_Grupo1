package fi.unju.edu.ar.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Cv;
import fi.unju.edu.ar.repository.ICvDAO;
import fi.unju.edu.ar.service.ICvService;

@Service
public class CvServiceImp implements ICvService {

@Autowired ICvDAO cvDao;

@Override
public void guardar(Cv curriculum) {
	
	 cvDao.save(curriculum);
}


}
