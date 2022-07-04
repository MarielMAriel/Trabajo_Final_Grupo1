/**
 * 
 */
package fi.unju.edu.ar.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Curso;
import fi.unju.edu.ar.repository.ICursoDao;
import fi.unju.edu.ar.service.ICursoService;

/**
 * @author 
 *
 */
@Service
public class ICursoServiceImp implements ICursoService{
	
	@Autowired
	ICursoDao cursoDao;

	@Override
	public Curso nuevoCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public List<Curso> listaCursos() {
		// TODO Auto-generated method stub
		return cursoDao.obtenerCurso();
	}

	@Override
	public Curso buscarCurso(Long id) {
		
		return cursoDao.findById(id).get();
	}
	
}
