package com.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Interseptor1 implements HandlerInterceptor {

	// Pre-handle: Executed before the controller method is invoked.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Inside Interceptor1 - PreHandle");
		// You can add logic here to check or modify the request.
		// Return true to proceed with the request handling, false to stop the request
		// from reaching the controller.
		return true;
	}

	// Post-handle: Executed after the controller method is executed but before the
	// view is rendered.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
		System.out.println("Inside Interceptor1 - PostHandle");
	}

	// After completion: Executed after the request is completely processed
	// (response sent).
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Inside Interceptor1 - AfterCompletion");
	}
}
