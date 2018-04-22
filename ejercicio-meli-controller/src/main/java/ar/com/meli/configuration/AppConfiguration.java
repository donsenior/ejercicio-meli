package ar.com.meli.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ar.com.meli.mutant.MutantDetector;

@Configuration
public class AppConfiguration {

	@Bean
	public MutantDetector mutantDetector() {
		return new MutantDetector();
	}
}
