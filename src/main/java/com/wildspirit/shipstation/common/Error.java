package com.wildspirit.shipstation.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Error {
    public final String message;

    public Error(@JsonProperty("Message") String message) {
        this.message = message;
    }
}
