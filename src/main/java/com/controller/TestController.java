package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("v1/")
public class TestController {

	@GetMapping("return-name")
	public String returnName() {
		System.out.println("=======================");
		System.out.println("Inside controller");
		System.out.println("=======================");

		return "Vishal Shinde";
	}
}
