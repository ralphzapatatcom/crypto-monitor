package com.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling // Permite que funcionen las tareas programadas en el paquete 'scheduler'
public class AppConfig {

    /**
     * Definimos RestTemplate como un Bean para que Spring lo pueda
     * inyectar automáticamente en nuestro CryptoClient.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    
}
