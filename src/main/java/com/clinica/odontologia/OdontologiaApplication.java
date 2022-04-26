package com.clinica.odontologia;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//El parámetro exclude fue para usar Postman y no recibir el código 401 al hacer las peticiones de prueba (Antes de configurar roles)
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class OdontologiaApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		SpringApplication.run(OdontologiaApplication.class, args);
	}

}
