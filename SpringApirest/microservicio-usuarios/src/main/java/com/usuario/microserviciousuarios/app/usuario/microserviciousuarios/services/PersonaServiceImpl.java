package com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.services;
import com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.models.entity.Persona;
import com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.models.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository repository;
    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return repository.save(persona);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
