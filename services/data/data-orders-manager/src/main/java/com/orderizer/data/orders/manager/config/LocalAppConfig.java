package com.orderizer.data.orders.manager.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "config")
@Configuration
@Data
public class LocalAppConfig {

    private Services services;

    @Data
    public static class Services {

        private ContextPath contextPath;

        @Data
        public static class ContextPath {
            private String dataGetOrdersManager;
            private String dataDeleteOrdersManager;
            private String dataSaveOrdersManager;
            private String dataUpdateOrdersManager;
        }

    }

}
