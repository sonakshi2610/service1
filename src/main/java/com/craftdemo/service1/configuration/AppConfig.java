package com.craftdemo.service1.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfig {
    @Value("${baseUrl.service2}")
    String service2BaseUrl;

}
