package com.apialumnos.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apialumnos.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.apialumnos.microservicios.commons.models.entity.Alumno;
import com.apialumnos.microservicios.commons.services.CommonServiceImpl;


@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>implements AlumnoService {

	@Override
	@Transactional(readOnly =true)
	public List<Alumno> finByNameOrLastName(String term) {
		
		return repository.finByNameOrLastName(term);
	}



}
