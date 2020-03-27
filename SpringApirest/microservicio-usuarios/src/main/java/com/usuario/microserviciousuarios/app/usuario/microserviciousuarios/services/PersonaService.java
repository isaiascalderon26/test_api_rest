package com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.services;

import com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.models.entity.Persona;

import java.util.Optional;

public interface PersonaService {

    public Iterable<Persona> findAll();

    public Optional<Persona> findById(Long id);

    public Persona save(Persona persona);

    public void deleteById(Long id);

}
