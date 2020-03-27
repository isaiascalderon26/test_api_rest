package com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.controllers;

import com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.models.entity.Persona;
import com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
        public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<Persona> o = service.findById(id);
        if (o.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
        }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Persona persona){

        Persona personaDb = service.save(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaDb);
    }
    @PutMapping("{/id}")
    public ResponseEntity<?> editar(@Valid  @RequestBody Persona persona, @PathVariable Long id, BindingResult result){

        if (result.hasErrors()){
            return this.validar(result);
        }

        Optional<Persona> o = service.findById(id);

        if (o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Persona personaDb = o.get();
        personaDb.setRut(persona.getRut());
        personaDb.setNombre(persona.getNombre());
        personaDb.setCorreo(persona.getCorreo());
        personaDb.setTelefono(persona.getTelefono());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personaDb));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    protected ResponseEntity<?> validar(BindingResult result){
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo" + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

    }
