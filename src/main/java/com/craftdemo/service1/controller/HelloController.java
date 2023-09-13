package com.craftdemo.service1.controller;

import com.craftdemo.requestfilter.util.RequestContext;
import com.craftdemo.requestfilter.response.ResponseDto;
import com.craftdemo.service1.service.HelloService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1/hello")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping
    public ResponseDto<String> helloApi() {
        long t1 = System.currentTimeMillis();
        helloService.triggerSuccessFailService2();
        log.info("Time taken by the API : {} ms", System.currentTimeMillis() - t1);
        return ResponseDto.<String>builder()
                .data("Hello triggered Successfully")
                .correlationId(RequestContext.getTraceId())
                .build();
    }

}
