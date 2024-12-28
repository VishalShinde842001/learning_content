package com.configs;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.filters.Filter1;
import com.filters.Filter2;

import jakarta.servlet.Filter;

//We can setOrder to the filter but if order is not defiend then it is considered as Integer.MAX_VALUE
@Configuration
public class FilterConfiguration {

	@Bean
	FilterRegistrationBean<Filter1> filter1() {
		FilterRegistrationBean<Filter1> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new Filter1());
		registrationBean.addUrlPatterns("/v1/*");
		registrationBean.setOrder(1); // You can specify order here
		return registrationBean;
	}

	@Bean
	FilterRegistrationBean<Filter2> filter2() {
		FilterRegistrationBean<Filter2> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new Filter2());
		registrationBean.addUrlPatterns("/v1/*");
		registrationBean.setOrder(2); // You can specify order here
		return registrationBean;
	}

}
