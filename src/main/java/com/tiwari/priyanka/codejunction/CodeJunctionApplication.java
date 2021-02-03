package com.tiwari.priyanka.codejunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CodeJunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeJunctionApplication.class, args);
	}

}
