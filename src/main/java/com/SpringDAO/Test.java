package com.SpringDAO;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		StudentDAO dao = new StudentDAO();
//		dao.selectAllRows(); 
////		dao.deleteSelectRecord(104);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
//		System.out.println("load the bean");
//		StudentDAO dao=context.getBean("student",StudentDAO.class);
//		dao.selectAllRows();
		Hello hel = context.getBean("hello", Hello.class);
		hel.test();

		// this is downCasting
//		why I'm calling this downcast bcz in super class close method is not available  it's available in class level
//		((ClassPathXmlApplicationContext) context).close();
		
		
		context.close();
	}

}
