package com.extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiseFileHandling {

	public static void main(String[] args) {
		try {
			/* String filePath = "src\\main\\resources\\testfile.properties"; */
			String filePath = "src\\main\\resources\\application.properties";

			// createPropertyFile(filePath);
			// updatePropertyFile(filePath);
			changeActiveProfile(filePath, "vishal");
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	// To create Properties file
	// Step 1: Simply create object of Properties type
	// Step 2: Now open file in writing Mode
	// Step 3: Simply call propertiesObject.store(file,"Comment")
	// Step 4: Simply call store method to store properties in that file
	public static void createPropertyFile(String filePath) throws Exception {

		// Created Properties to set to store
		Properties p = new Properties();
		p.setProperty("name", "vishal");
		p.setProperty("surname", "Shinde");
		FileOutputStream file = new FileOutputStream(filePath);

		p.store(file, "This is just creating dynamic file");

	}

	public static void updatePropertyFile(String path) throws Exception {
		FileInputStream file = new FileInputStream(path);

		Properties p = new Properties();
		p.load(file);
		file.close();

		for (Object obj : p.keySet()) {
			System.out.println(obj + " : " + p.getProperty((String) obj));
		}

		FileOutputStream filePath = new FileOutputStream(path);
		p.setProperty("name", "Testing Name");

		p.store(filePath, "Testing");
		for (Object obj : p.keySet()) {
			System.out.println(obj + " : " + p.getProperty((String) obj));
		}
		filePath.close();
	}

	public static void changeActiveProfile(String filePath, String activeProfile) throws Exception {

		FileInputStream file = new FileInputStream(filePath);
		Properties p = new Properties();
		p.load(file);

		file.close();
		FileOutputStream writableFile = new FileOutputStream(filePath);
		p.setProperty("spring.profiles.active", activeProfile);

		p.store(writableFile, "Change Active Profile");

	}

}
