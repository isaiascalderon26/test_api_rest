package com.apialumnos.microservicios.app.curse.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.apialumnos.microservicios.commons.models.entity.Alumno;

@Entity
@Table(name="curse")
public class Curse {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String name;
	
	@Pattern(regexp = "[0-9] {4}", message=" Only 4 at most")
	private Integer code;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Alumno> alumnos;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	public Curse() {
		this.alumnos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}

	public void removeAlumno(Alumno alumno) {
		this.alumnos.remove(alumno);
	}
}
