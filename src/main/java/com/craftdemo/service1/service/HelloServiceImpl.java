package com.craftdemo.service1.service;

import com.craftdemo.service1.configuration.AppConfig;
import com.craftdemo.service1.exceptions.CustomRunTimeExceptions;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Autowired
    AppConfig appConfig;

    @Autowired
    Service2Service service2Service;

    public void triggerSuccessFailService2() {
        CompletableFuture<Response> successResponse = service2Service.triggerSuccessApi();
        CompletableFuture<Response> failResponse = service2Service.triggerFailApi();
        try {
            logResponse(successResponse.get());
            logResponse(failResponse.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new CustomRunTimeExceptions(String.format("Error while getting async response : %s", e.getMessage()));
        }

    }

    private void logResponse(Response response) {
        log.info("Response from API -> {} and Status code -> {}", response.getResponseBody(), response.getStatusCode());
    }


}
