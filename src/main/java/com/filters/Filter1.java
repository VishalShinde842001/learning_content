package com.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//For Configuration of filter create class whchimplements jakarta.servlet.Filter class
//By Doin only this not Considered as Filter configuraed
//After that you need to Configure for which route which filter should invoke 
//What is order of filter and all in Configuration Class of Filter
public class Filter1 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Inside Filter 1");
		chain.doFilter(request, response);

	}

}
