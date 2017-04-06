package com.cloud.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloud.pc.entity.KafkaProperties;

@SpringBootApplication
public class CloudnextApplication {

	public static void main(String[] args) {				
		SpringApplication.run(CloudnextApplication.class, args);		
	}
}
