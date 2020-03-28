package com.apialumnos.microservicios.app.curse.services;

import com.apialumnos.microservicios.app.curse.models.entity.Curse;
import com.apialumnos.microservicios.commons.services.CommonService;

public interface CurseService extends CommonService<Curse> {

	public Curse findCurseByAlumnoId(Long id);
}
