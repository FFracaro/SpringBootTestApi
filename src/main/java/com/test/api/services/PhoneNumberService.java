package com.test.api.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhoneNumberService {
    private final RestTemplate restTemplate;

    public PhoneNumberService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String getPhoneNumberData(String phoneNumber) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return this.restTemplate.getForObject(url, String.class);
    }
}
