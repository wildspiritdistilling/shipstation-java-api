package com.wildspirit.shipstation;

public final class ShipStationException extends RuntimeException {
    
    public final int httpCode;

    public ShipStationException(String message, int httpCode) {
        super(message);
        this.httpCode = httpCode;
    }

    public ShipStationException(String message) {
        super(message);
        httpCode = 500;
    }

    public ShipStationException(String message, Throwable cause) {
        super(message, cause);
        httpCode = 500;
    }
}
