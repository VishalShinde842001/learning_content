package com.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class Filter3 implements Filter {
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain filterChain) throws ServletException , IOException{
		System.out.println("Inside Filter 3");
		filterChain.doFilter(request, response);
	}

}
