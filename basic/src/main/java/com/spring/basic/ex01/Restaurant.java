package com.spring.basic.ex01;

public class Restaurant { //Restaurant는 Chef에 의존적

	private Chef chef;
	/*
	public Restaurant(Chef chef) {
		// TODO Auto-generated constructor stub
		System.out.println("레스토랑이 생성됨!");
		this.chef = chef;
	}
	*/
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void orderDinner() {
		System.out.println("저녁식사를 주문합니다.");
		chef.cook();
	}
}
