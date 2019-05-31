package com.example.grpcclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Slf4j
@Component
public class GrpcClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(GrpcClientApplication.class, args);


	}

}
