package com.wildspirit.shipstation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wildspirit.shipstation.common.AbstractApi;
import com.wildspirit.shipstation.orders.OrdersApi;
import okhttp3.OkHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ShipStation extends AbstractApi {
    public ShipStation(String apiKey, String apiSecret) {
        super(new OkHttpClient(), encode(apiKey, apiSecret), createMapper());
    }

    public OrdersApi orders() {
        return new OrdersApi(http, authorization, mapper);
    }

    private static String encode(String apiKey, String apiSecret) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.writeBytes(apiKey.getBytes(StandardCharsets.UTF_8));
        os.writeBytes(":".getBytes(StandardCharsets.UTF_8));
        os.writeBytes(apiSecret.getBytes(StandardCharsets.UTF_8));
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode(os.toByteArray());
        return new String(encoded);
    }

    private static ObjectMapper createMapper() {
        SimpleModule lowerCaseEnums = new SimpleModule();
        lowerCaseEnums.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<Enum> modifyEnumDeserializer(DeserializationConfig config,
                                                                 final JavaType type,
                                                                 BeanDescription beanDesc,
                                                                 final JsonDeserializer<?> deserializer) {
                return new JsonDeserializer<>() {
                    @Override
                    public Enum deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                        Class<? extends Enum> rawClass = (Class<Enum<?>>) type.getRawClass();
                        return Enum.valueOf(rawClass, jp.getValueAsString().toUpperCase());
                    }
                };
            }
        });
        return new ObjectMapper()
                .registerModule(lowerCaseEnums)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
