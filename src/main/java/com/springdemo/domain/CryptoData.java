package com.springdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Esta clase representa el modelo de datos de la criptomoneda.
 * Usamos @JsonIgnoreProperties por si la API envía más datos de los que necesitamos.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoData {

    // El nombre del símbolo (ej: BTCUSDT)
    @JsonProperty("symbol")
    private String symbol;

    // El precio actual
    @JsonProperty("price")
    private String price;

    // Marca de tiempo de la captura (opcional, útil para el monitoreo)
    private long timestamp;

    // Constructor vacío requerido por Jackson (para convertir de JSON a Objeto)
    public CryptoData() {
        this.timestamp = System.currentTimeMillis();
    }

    public CryptoData(String symbol, String price) {
        this.symbol = symbol;
        this.price = price;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters y Setters
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CryptoData{" +
                "symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
