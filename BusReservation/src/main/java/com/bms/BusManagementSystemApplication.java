package com.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bms")
@EntityScan(value = "com.bms.entity")
public class BusManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusManagementSystemApplication.class, args);
	}

}
