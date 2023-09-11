package com.craftdemo.service1.service;

import com.craftdemo.service1.configuration.AppConfig;
import com.craftdemo.service1.util.RestCallUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class Service2ServiceImpl implements Service2Service {

    @Autowired
    AppConfig appConfig;

    public CompletableFuture<Response> triggerSuccessApi() {
        return RestCallUtil.callService2APIAsync(appConfig.getService2BaseUrl() + "/success");
    }

    public CompletableFuture<Response> triggerFailApi() {
        return RestCallUtil.callService2APIAsync(appConfig.getService2BaseUrl() + "/fail");
    }
}
