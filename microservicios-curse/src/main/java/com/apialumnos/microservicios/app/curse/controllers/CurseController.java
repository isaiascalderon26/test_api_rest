package com.apialumnos.microservicios.app.curse.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apialumnos.microservicios.app.curse.models.entity.Curse;
import com.apialumnos.microservicios.app.curse.services.CurseService;
import com.apialumnos.microservicios.commons.controller.CommonController;
import com.apialumnos.microservicios.commons.models.entity.Alumno;

@RestController
public class CurseController extends CommonController<Curse, CurseService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Curse curse, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Curse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
	}
	Curse dbCurse = o.get();
	dbCurse.setName(curse.getName());
	dbCurse.setCode(curse.getCode());
	return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurse));
	}
	
	@PutMapping("/{}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
		Optional<Curse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
	 }
	 Curse dbCurse = o.get();
	 
	 alumnos.forEach(a -> {
		 dbCurse.addAlumno(a);
	 });
	 return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurse));
  }
	@PutMapping("/{}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Curse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
	 }
	 Curse dbCurse = o.get();
	 
	 dbCurse.removeAlumno(alumno);
	
	 return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurse));
  }

	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id){
		Curse curse = service.findCurseByAlumnoId(id);
		return ResponseEntity.ok(curse);
	}
}
