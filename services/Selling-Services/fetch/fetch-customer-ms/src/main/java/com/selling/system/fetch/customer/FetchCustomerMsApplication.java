package com.selling.system.fetch.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableReactiveMongoRepositories
@EnableDiscoveryClient
public class FetchCustomerMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FetchCustomerMsApplication.class, args);
    }

}