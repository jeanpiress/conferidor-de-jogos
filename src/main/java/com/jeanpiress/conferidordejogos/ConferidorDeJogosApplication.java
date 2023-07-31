package com.jeanpiress.conferidordejogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jeanpiress.conferidordejogos.config.property.ApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperty.class)
public class ConferidorDeJogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferidorDeJogosApplication.class, args);
		
		
	
		
	}
	
	
}
