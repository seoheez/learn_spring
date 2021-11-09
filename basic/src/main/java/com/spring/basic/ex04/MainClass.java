package com.spring.basic.ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.sun.tools.javac.resources.ct;

public class MainClass {
	
	public static void main(String[] args) {
		
//		Printer printer = new Printer(new Paper());
//		printer.showPaperInfo();
		
		GenericXmlApplicationContext ct 
			= new GenericXmlApplicationContext("classpath:auto-config.xml");
		
		Printer printer = ct.getBean("prt", Printer.class);
		printer.showPaperInfo();
		
		ct.close();
		
	}
}