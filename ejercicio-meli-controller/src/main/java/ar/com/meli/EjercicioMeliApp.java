package ar.com.meli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class EjercicioMeliApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioMeliApp.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EjercicioMeliApp.class);
	}

}
