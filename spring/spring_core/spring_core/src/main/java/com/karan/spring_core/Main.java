package com.karan.spring_core;

import java.io.ObjectInputFilter.Config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.karan.spring_core.config.BeanConfig;
import com.karan.spring_core.model.Computer;

public class Main {
	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		BeanFactory factory = new 
		Computer computer = context.getBean(Computer.class);
		
		System.out.println(computer);
	}

}
