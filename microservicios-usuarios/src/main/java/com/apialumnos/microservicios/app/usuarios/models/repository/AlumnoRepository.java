package com.apialumnos.microservicios.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.apialumnos.microservicios.commons.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
	
	 @Query("select a from Alumnno where a.name like %?1% or a.lastname like %?1%")
	 public List<Alumno> finByNameOrLastName(String term);
	 
}