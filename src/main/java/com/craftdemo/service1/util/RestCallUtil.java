package com.craftdemo.service1.util;

import com.craftdemo.requestfilter.httpClients.CustomAsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;

public class RestCallUtil {
    public static CompletableFuture<Response> callService2APIAsync(String apiUrl) {
        CustomAsyncHttpClient asyncHttpClient = new CustomAsyncHttpClient();
        return asyncHttpClient
                .executeGetWithMDC(apiUrl);
    }
}
