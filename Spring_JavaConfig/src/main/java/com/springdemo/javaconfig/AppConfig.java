package com.springdemo.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name="helloWorld")
	public HelloWorld helloWorld(){
		return new HelloWorldImpl();
	}
}
