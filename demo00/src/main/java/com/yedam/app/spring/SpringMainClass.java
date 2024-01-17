package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		//// TODO Auto-generated method stub
		// GenericXmlApplicationContext
		System.out.println("Spring 방식");
		ApplicationContext
		
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("Spring 방식");
		TV tv = (TV)ctx.getBean("tv");
		tv.on();
	}

}
