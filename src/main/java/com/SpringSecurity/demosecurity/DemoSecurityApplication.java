package com.SpringSecurity.demosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
//		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//		System.out.println(encoder.encode("saikat123"));
//		System.out.println(encoder.encode("sumit123"));


	}

}
