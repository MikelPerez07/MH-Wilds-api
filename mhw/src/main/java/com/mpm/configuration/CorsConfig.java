package com.mpm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // Aplica CORS a todas las rutas
				.allowedOrigins("http://localhost:4201") // Permite solicitudes desde este origen
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
				.allowedHeaders("*") // Permite todos los encabezados
				.allowCredentials(true); // Permite enviar cookies si es necesario
	}
}
