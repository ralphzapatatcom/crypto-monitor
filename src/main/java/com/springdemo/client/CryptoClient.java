package com.springdemo.client;

import com.springdemo.domain.CryptoData; // Asumiendo que tendrás un DTO en domain
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Component
public class CryptoClient {

    private final RestTemplate restTemplate;

    // Podrías configurar esta URL en tu application.properties
    @Value("${crypto.api.url:https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT}")
    private String apiUrl;

    public CryptoClient() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Obtiene el precio actual de la criptomoneda desde la API externa.
     */
    public CryptoData fetchMarketData() {
        try {
            // Consumimos la API y mapeamos la respuesta a nuestro objeto de dominio
            return restTemplate.getForObject(apiUrl, CryptoData.class);
        } catch (Exception e) {
            // Aquí podrías implementar un log o manejo de errores personalizado
            System.err.println("Error al conectar con la API de Crypto: " + e.getMessage());
            return null;
        }
    }
}