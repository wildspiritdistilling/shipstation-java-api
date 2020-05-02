package com.wildspirit.shipstation.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildspirit.shipstation.ShipStationException;
import io.mikael.urlbuilder.UrlBuilder;
import okhttp3.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public abstract class AbstractApi {
    protected final OkHttpClient http;
    protected final String authorization;
    protected final ObjectMapper mapper;
    protected static final SimpleDateFormat ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    protected static final String ENDPOINT = "https://ssapi.shipstation.com/";

    protected AbstractApi(OkHttpClient http, String authorization, ObjectMapper mapper) {
        this.http = http;
        this.authorization = authorization;
        this.mapper = mapper;
    }

    protected <T> T httpGet(String url, Class<T> responseClazz) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Basic " + authorization)
                .build();

        try (Response response = http.newCall(request).execute()) {

            switch (response.code()) {
                case 200:
                    return mapper.readValue(response.body().bytes(), responseClazz);
                default:
                    String message;
                    try {
                        String errorBody = response.body().string();
                        Error error = mapper.readValue(errorBody, Error.class);
                        message = error.message;
                    } catch (Throwable e) {
                        message = response.message();
                    }
                    throw new ShipStationException(message, response.code());
            }
        } catch (IOException e) {
            throw new ShipStationException("Could not map " + responseClazz.getName(), e);
        }
    }

    protected <T> T httpPost(String url, Object object, Map<String, String> params, Class<T> responseClazz) {
        byte[] bytes;
        try {
            bytes = mapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        RequestBody requestBody = RequestBody.create(bytes, MediaType.get("application/json"));
        Request.Builder builder = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Basic " + authorization)
                .post(requestBody);
        params.forEach(builder::addHeader);
        Request request = builder.build();
        try (Response response = http.newCall(request).execute()) {
            return mapper.readValue(response.body().bytes(), responseClazz);
        } catch (IOException e) {
            throw new ShipStationException("Could not map " + responseClazz.getName(), e);
        }
    }

    protected UrlBuilder withEndpoint() {
        return UrlBuilder.fromString(ENDPOINT);
    }
}
