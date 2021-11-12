package com.spring.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		//session.setAttribute	//request.setAttribute 와 비슷
		model.addAttribute("serverTime", formattedDate );

		return "home";	//jsp파일명
	}

	//test.jsp를 열기 위한 요청 메서드 구성
	@RequestMapping(value="/test", method=RequestMethod.GET)	//디스패처서블릿에게 /test가 get으로 들어오면 test메서드를 호출해달라는 의미
	public String test() {
		System.out.println("/test 요청이 들어옴: GET방식!");
		return "test";
	}
}
