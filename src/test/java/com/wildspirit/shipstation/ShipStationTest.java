package com.wildspirit.shipstation;

import com.wildspirit.shipstation.orders.GetOrdersRequest;
import org.junit.Test;

public class ShipStationTest {
    @Test
    public void testShipStation() throws Exception {
        ShipStation ss = new ShipStation(fromEnvironment("SHIPSTATION_KEY"), fromEnvironment("SHIPSTATION_SECRET"));
        ss.orders().all(new GetOrdersRequest.Builder().build())
                .forEach(order -> System.out.println(order.shipTo.name));
    }

    public static String fromEnvironment(String envName) {
        String key = System.getenv(envName);
        if (key == null || key.isEmpty()) {
            throw new IllegalStateException(envName + " not set");
        }
        return key;
    }
}
