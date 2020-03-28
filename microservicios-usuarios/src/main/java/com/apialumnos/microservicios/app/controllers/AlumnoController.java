package com.apialumnos.microservicios.app.controllers;

import java.util.Optional;

import javax.naming.Binding;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apialumnos.microservicios.app.usuarios.services.AlumnoService;
import com.apialumnos.microservicios.commons.controller.CommonController;
import com.apialumnos.microservicios.commons.models.entity.Alumno;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {
    	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno, BindingResult result, @PathVariable Long id ){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Alumno> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoDAlumno = o.get();
		alumnoDAlumno.setRut(alumno.getRut());
		alumnoDAlumno.setName(alumno.getName());
		alumnoDAlumno.setLastname(alumno.getLastname());
		alumnoDAlumno.setAge(alumno.getAge());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDAlumno));
		
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.finByNameOrLastName(term));

	}

}
