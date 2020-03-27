package com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.models.repository;

import com.usuario.microserviciousuarios.app.usuario.microserviciousuarios.models.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository <Persona, Long>{

}
