package com.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.filters.Interseptor1;

@Configuration
public class InterseptorConfiguration implements WebMvcConfigurer {

	public void add(InterceptorRegistry registry) {
		registry.addInterceptor(new Interseptor1()).addPathPatterns("/v1/*");
	}

}
