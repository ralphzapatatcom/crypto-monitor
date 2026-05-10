package com.springdemo.scheduler;

import com.springdemo.client.CryptoClient;
import com.springdemo.domain.CryptoData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CryptoScheduler {

    private static final Logger log = LoggerFactory.getLogger(CryptoScheduler.class);
    private final CryptoClient cryptoClient;

    // Inyección del cliente que creamos anteriormente
    public CryptoScheduler(CryptoClient cryptoClient) {
        this.cryptoClient = cryptoClient;
    }

    /**
     * Ejecuta la tarea de monitoreo cada 5 segundos (5000ms).
     * El 'fixedRate' asegura que el intervalo comience desde el inicio de la tarea anterior.
     */
    @Scheduled(fixedRate = 5000)
    public void monitorCryptoPrice() {
        CryptoData data = cryptoClient.fetchMarketData();

        if (data != null) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            // Logueamos la información en la consola para ver el monitoreo en tiempo real
            log.info("[{}] Monitor - Símbolo: {} | Precio: $ {}",
                    time, data.getSymbol(), data.getPrice());
        } else {
            log.error("No se pudo obtener la información de la criptomoneda.");
        }
    }
}
