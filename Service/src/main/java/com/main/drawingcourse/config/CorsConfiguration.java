package com.main.drawingcourse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // Apply CORS configuration to all endpoints
				.allowedOriginPatterns("*") // Allow requests from all origins (you can restrict this as needed)
				.allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
				.allowedHeaders("*") // Allow all headers
				.allowCredentials(true) // Allow sending of cookies
				.maxAge(3600); // Max age of the CORS pre-flight response cache
	}
}
