package com.spring.basic.ex02;

public class MemberDAO {
	private DatabaseInfo dbInfo;
	
	public void setDbInfo(DatabaseInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	
	public void showDBInfo() {
		System.out.println("URL: " + dbInfo.getUrl());
		System.out.println("UID: " + dbInfo.getUid());
		System.out.println("UPW: " + dbInfo.getUpw());
		

	}
}
