package com.spring.basic.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ct
			= new GenericXmlApplicationContext("classpath:prototype-config.xml");
		
		Person hong = ct.getBean("person", Person.class);
		Person jeong = ct.getBean("person", Person.class);
		
		System.out.println("hong의 주소:" + hong);
		System.out.println("jeong의 주소:" + jeong);
		System.out.println("hong과 jeong은 같은 객체인가?? " + (hong == jeong));
		
		System.out.println("==========================");
		jeong.setName("정서희");
		jeong.setAge(27);
		
		System.out.println("hong의 이름: " + hong.getName());
		System.out.println("hong의 나이: " + hong.getAge());
		System.out.println("hong의 이름: " + jeong.getName());
		System.out.println("hong의 나이: " + jeong.getAge());
	}
}
