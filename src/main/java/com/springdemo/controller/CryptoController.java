package com.springdemo.controller;

import com.springdemo.client.CryptoClient;
import com.springdemo.domain.CryptoData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/crypto") // Definimos la ruta base
public class CryptoController {

    private final CryptoClient cryptoClient;

    // Inyectamos el cliente por constructor
    public CryptoController(CryptoClient cryptoClient) {
        this.cryptoClient = cryptoClient;
    }

    /**
     * Endpoint para obtener el precio actual "bajo demanda".
     * URL: http://localhost:8080/api/v1/crypto/now
     */
    @GetMapping("/now")
    public ResponseEntity<CryptoData> getCurrentPrice() {
        CryptoData data = cryptoClient.fetchMarketData();

        if (data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.status(503).build(); // Service Unavailable
        }
    }

    /**
     * Endpoint de prueba para verificar que el monitor está en línea.
     */
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Crypto Monitor is running and healthy.");
    }
}
