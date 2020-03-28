package com.apialumnos.microservicios.app.curse.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.apialumnos.microservicios.app.curse.models.entity.Curse;

public interface CurseRepository extends CrudRepository<Curse, Long> {

	@Query("select c from Curse c join fetch c.alumnnos a where a.id=?1")
	public Curse findCurseByAlumnoId(Long id);
}
