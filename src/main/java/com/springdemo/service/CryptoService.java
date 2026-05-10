package com.springdemo.service;

import com.springdemo.client.CryptoClient;
import com.springdemo.domain.CryptoData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CryptoService {

    private final CryptoClient cryptoClient;

    // Lista en memoria para guardar el historial reciente (ej. últimos 10 precios)
    private final List<CryptoData> priceHistory = Collections.synchronizedList(new ArrayList<>());
    private static final int MAX_HISTORY_SIZE = 10;

    public CryptoService(CryptoClient cryptoClient) {
        this.cryptoClient = cryptoClient;
    }

    /**
     * Lógica para obtener el último precio, procesarlo y guardarlo en el historial.
     */
    public CryptoData processCurrentPrice() {
        CryptoData data = cryptoClient.fetchMarketData();

        if (data != null) {
            // Guardamos en el historial
            priceHistory.add(0, data); // Agregamos al inicio

            // Mantenemos solo los últimos 10
            if (priceHistory.size() > MAX_HISTORY_SIZE) {
                priceHistory.remove(priceHistory.size() - 1);
            }
        }
        return data;
    }

    /**
     * Retorna el historial de precios recolectados.
     */
    public List<CryptoData> getPriceHistory() {
        return new ArrayList<>(priceHistory);
    }

    /**
     * Lógica de negocio: Calcula si el precio es mayor a un umbral.
     */
    public boolean isPriceAbove(double threshold) {
        CryptoData lastData = (priceHistory.isEmpty()) ? null : priceHistory.get(0);
        if (lastData != null) {
            return Double.parseDouble(lastData.getPrice()) > threshold;
        }
        return false;
    }
}
