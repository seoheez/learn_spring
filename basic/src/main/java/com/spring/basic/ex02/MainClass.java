package com.spring.basic.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		/*
		DatabaseInfo dbInfo = new DatabaseInfo();
		dbInfo.setUid("spring1");
		dbInfo.setUpw("sss123");
		dbInfo.setUrl("jdbc:mysql://localhost:3306/spring");
		*/
		GenericXmlApplicationContext ct 
			= new GenericXmlApplicationContext("classpath:db-config.xml"); //db-config.xml에 Bean 등록해놓음.
		
		DatabaseInfo db1 = ct.getBean("db1", DatabaseInfo.class); //불러올 Bean 아이디는 db1 뿐. DatabaseInfo라는 class로 가져옴.
		System.out.println("URL: " + db1.getUrl());
		System.out.println("UID: " + db1.getUid());
		System.out.println("UPW: " + db1.getUpw());
		//이렇게 할 경우 데이터가 변경됐을 때 서버쪽 로직을 건들이지 않아도 되는 장점이 있음.
		
		System.out.println("===============================");
		
		DatabaseInfo db2 = ct.getBean("db2", DatabaseInfo.class);
		System.out.println("URL: " + db2.getUrl());
		System.out.println("UID: " + db2.getUid());
		System.out.println("UPW: " + db2.getUpw());
		
		System.out.println("=======================");
		/*
		MemberDAO dao = new MemberDAO();
		dao.setDbInfo(db1); //이 방법으로 한다면 이걸 적어야지 NullPointerException 오류가 뜨지 않음.
		dao.showDBInfo();
		*/
		
		MemberDAO dao = ct.getBean("dao", MemberDAO.class); //주입을 해두었기 때문에 db1에 대한 정보가 나타남. 
		dao.showDBInfo();
		//메인 서버쪽 코드를 건들지 않더라도 xml을 수정하면 서버로직을 수정할 수 있음. 유지보수, 생산성 측면에서 효율적.
	}
}
