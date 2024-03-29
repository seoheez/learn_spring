package com.spring.basic.ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
//		Chef chef = new Chef();
//		Restaurant res = new Restaurant(chef);
//		Hotel hotel = new Hotel(res);   
		Hotel hotel = new Hotel(new Restaurant(new Chef()));  //한줄로
		hotel.reserveRestaurant();
		*/
		GenericXmlApplicationContext ct 
			= new GenericXmlApplicationContext("classpath:test-config.xml"); //이 설정파일에 정보를 갖고있는 객체가 ct에 저장
		
		Hotel hotel = ct.getBean("hotel", Hotel.class); //container에서 hotel이라는 id값을 가진 bean을 hotel에 class모양으로 가져옴.
		hotel.reserveRestaurant();
	}

}
