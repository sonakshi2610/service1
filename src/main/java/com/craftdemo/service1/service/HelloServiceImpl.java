package com.craftdemo.service1.service;

import com.craftdemo.service1.configuration.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService{

    @Autowired
    AppConfig appConfig;

    @Autowired
    Service2Service service2Service;

    public void triggerSuccessFailService2() {
        CompletableFuture<Response> successResponse = service2Service.triggerSuccessApi();
        CompletableFuture<Response> failResponse = service2Service.triggerFailApi();
        printResponse(successResponse);
        printResponse(failResponse);
    }

    private void printResponse(CompletableFuture<Response> responseCompletableFuture) {
        try {
            Response response = responseCompletableFuture.get();
            log.info("Status code : {}", response.getStatusCode());
            log.info("Response body : {}", response.getResponseBody());
        } catch (InterruptedException | ExecutionException e) {
            // Handle any exceptions that may occur
        }
    }


}
