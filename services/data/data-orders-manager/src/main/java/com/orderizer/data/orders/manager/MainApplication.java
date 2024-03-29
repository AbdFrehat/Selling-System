package com.orderizer.data.orders.manager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {
        "com.orderizer.data.orders.manager",
        "com.selling.system.shared.module"
})
@OpenAPIDefinition(info = @Info(title = "data-orders-manager", version = "1.0", description = "Documentation APIs v1.0"))
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
