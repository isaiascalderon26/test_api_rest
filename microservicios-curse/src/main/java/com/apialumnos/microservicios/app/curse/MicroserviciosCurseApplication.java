package com.apialumnos.microservicios.app.curse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.apialumnos.microservicios.commons.models.entity",
			"com.apialumnos.microservicios.app.curse.models.entity"})
public class MicroserviciosCurseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCurseApplication.class, args);
	}

}
