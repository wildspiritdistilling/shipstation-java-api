package com.wildspirit.shipstation;

public final class ShipStationException extends RuntimeException {
    public ShipStationException(String message) {
        super(message);
    }

    public ShipStationException(String message, Throwable cause) {
        super(message, cause);
    }
}
