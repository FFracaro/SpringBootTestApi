package com.test.api.models;

public record PhoneNumber(
    boolean valid, String localFormat, String intlFormat,
    String countryCode, String countryName, String location,
    String carrier, String lineType
) {}
