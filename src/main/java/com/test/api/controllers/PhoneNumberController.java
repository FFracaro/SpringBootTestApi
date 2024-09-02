package com.test.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.api.services.PhoneNumberService;

@RestController
@RequestMapping("/phone")
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<String> find(@PathVariable String phoneNumber) {

        String phoneNumberReponse = phoneNumberService.getPhoneNumberData(phoneNumber);

        return ResponseEntity.ok().body(phoneNumberReponse);
    }
}
