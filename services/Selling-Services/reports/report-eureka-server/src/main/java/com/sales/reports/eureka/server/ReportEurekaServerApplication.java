package com.sales.reports.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ReportEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportEurekaServerApplication.class, args);
	}

}
