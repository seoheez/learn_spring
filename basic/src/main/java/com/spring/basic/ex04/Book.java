package com.spring.basic.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Book {
		@Autowired
		@Qualifier("paper2")
		private Paper paper;
		
		public void setPaper(Paper paper) {
			this.paper = paper;
		}
		
		public Paper getPaper() {
			return paper;
		}
}
