package com.protick.learnspringframework.examples.h1;

import com.protick.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class XmlConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {

		try (var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			System.out.println("Name: "+context.getBean("name"));
			System.out.println("Age: "+context.getBean("age"));
			context.getBean(GameRunner.class).run();

		}
	}
}
