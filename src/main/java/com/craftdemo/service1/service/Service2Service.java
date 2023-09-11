package com.craftdemo.service1.service;

import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;

public interface Service2Service {
    CompletableFuture<Response> triggerSuccessApi();
    CompletableFuture<Response> triggerFailApi();
}
