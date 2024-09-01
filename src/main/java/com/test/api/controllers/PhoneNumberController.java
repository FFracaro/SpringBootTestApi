package com.test.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.api.models.PhoneNumber;

@RestController
@RequestMapping("/phone")
public class PhoneNumberController {
    @GetMapping("/{phoneNumber}")
    public ResponseEntity<PhoneNumber> find(@RequestParam String phoneNumber) {
        PhoneNumber phoneNumberReponse = new PhoneNumber(
            false, 
            "", 
            "", 
            "", 
            "", 
            "", 
            "", 
            "");

        return ResponseEntity.ok(phoneNumberReponse);
    }
}
