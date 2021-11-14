package com.spring.web.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 어노테이션
@Controller
@RequestMapping("/request") //아래에 /request를 제거해도 됨.
public class RequestController {

	public RequestController() {
		System.out.println("RequestController 작동!");
	}
	
	//RequestMapping은 어떤 URI로 이 메서드를 동작시킬 것인가에 대한 설정입니다.
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}
	
	/*
	 만약  /request/req 요청이 들어왔을 때 
	 views폴더 아래에 있는 request폴더 아래에
	 req-ex01.jsp파일을 열도록 메서드를 구성해보기.
	 */
	
	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴!");
		return "request/req-ex01";
	}
	//@RequestMapping(value="/request/basic01", method=RequestMethod.GET) //get방식 전용 메서드가 된 것.
	@GetMapping("/basic01")
	public String basicGet() {
		System.out.println("/request/basic01 요청이 들어옴: GET");
		return "request/req-ex01";
	}
	//@RequestMapping(value="/request/basic01", method=RequestMethod.POST) //같은 uri로 post방식.
	@PostMapping("/basic01")
	public String basicPost() {
		System.out.println("/request/basic01 요청이 들어옴: POST");
		return "request/req-ex01";
	}
	
	//컨트롤러의 요청메서드를 void리턴타입으로 지정.1
	@GetMapping("/req-ex02") //앞에 /request가 붙어있음.
	public void reqEx02() {
		System.out.println("/request/req-ex02요청!");
	}
	
	//요청 파라미터 받아보기
	@GetMapping("/param")
	public String paramTest(HttpServletRequest request) {
		System.out.println("/request/param 요청: GET");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		
		return "";
	}
	//////////////////////////////////////////////////////
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join : GET");
	}
	/*
	  	# 1. 전통적인 jsp/servlet의 파라미터 읽기처리 방법
	  	- HttpServletRequest 객체를 사용
	 */
	
	@PostMapping("/join")
	public String register(HttpServletRequest request) { //중복선언은 매개변수 필요함.
		System.out.println("/request/join : POST");
		
		System.out.println("ID:" + request.getParameter("userId")); //join.jsp 파일에 적은것과 똑같이.
		System.out.println("PW:" + request.getParameter("userPw"));
		System.out.println("HOBBY:" + Arrays.toString(request.getParameterValues("hobby"))); //배열
		
		return "request/join";
	}
}




