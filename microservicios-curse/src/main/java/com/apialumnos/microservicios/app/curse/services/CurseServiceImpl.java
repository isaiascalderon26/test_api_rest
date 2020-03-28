package com.apialumnos.microservicios.app.curse.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apialumnos.microservicios.app.curse.models.entity.Curse;
import com.apialumnos.microservicios.app.curse.models.repository.CurseRepository;
import com.apialumnos.microservicios.commons.services.CommonServiceImpl;

@Service
public class CurseServiceImpl extends CommonServiceImpl<Curse, CurseRepository> implements CurseService {

	@Override
	@Transactional(readOnly = true)
	public Curse findCurseByAlumnoId(Long id) {
		return repository.findCurseByAlumnoId(id);
	}
	
}
