package com.example.cachingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.cachingdemo.model.Users;
import com.example.cachingdemo.service.UserServiceImpl;

@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = JmxAutoConfiguration.class)
public class CachingDemoApplication {

	@Autowired 
	UserServiceImpl userService;
	public static void main(String[] args) {
		SpringApplication.run(CachingDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run() {
		return args -> {
			Users u1 = userService.getUserByUserId("ddc");
			System.out.println(u1);
			Users u2 = userService.getUserByUserId("ddc");
			System.out.println(u2);
		};
	}
}
