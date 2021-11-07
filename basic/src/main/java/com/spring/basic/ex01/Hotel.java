package com.spring.basic.ex01;

public class Hotel { //Hotel은 Restaurant에 의존적
	
	private Restaurant res;
	
	public Hotel(Restaurant res) {
		// TODO Auto-generated constructor stub
		System.out.println("호텔이 생성됨!");
		this.res = res;
	}
	
	public void reserveRestaurant() {
		System.out.println("레스토랑을 예약합니다.");
		res.orderDinner();
	}
}
