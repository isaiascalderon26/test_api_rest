package com.apialumnos.microservicios.app.usuarios.services;

import java.util.List;

import com.apialumnos.microservicios.commons.models.entity.Alumno;
import com.apialumnos.microservicios.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno>{
	public List<Alumno> finByNameOrLastName(String term);

}
