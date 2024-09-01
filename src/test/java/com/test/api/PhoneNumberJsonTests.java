package com.test.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import com.test.api.models.PhoneNumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

@SpringBootTest
public class PhoneNumberJsonTests {

    @Autowired
    JacksonTester<PhoneNumber> json;
    
    @Test
    void PhoneNumberSerializationTest() throws IOException {
        PhoneNumber phoneNumber = new PhoneNumber(true,   
        "4158586273",
        "+14158586273",
        "US",
        "United States of America",
        "Novato",
        "AT&T Mobility LLC",
        "mobile");

        JsonContent<PhoneNumber> phoneNumberJson = json.write(phoneNumber);
        assertThat(phoneNumberJson)
            .isStrictlyEqualToJson("PhoneNumber.json");
        

        assertThat(phoneNumberJson)
            .hasJsonPathBooleanValue("@.valid");

        assertThat(phoneNumberJson)
            .extractingJsonPathBooleanValue("@.valid")
            .isTrue();

        assertThat(phoneNumberJson)
            .hasJsonPathStringValue("@.localFormat");

        assertThat(phoneNumberJson)
            .extractingJsonPathStringValue("@.localFormat")
            .isEqualTo("4158586273");

        assertThat(phoneNumberJson)
            .hasJsonPathStringValue("@.intlFormat");

        assertThat(phoneNumberJson)
            .extractingJsonPathStringValue("@.intlFormat")
            .isEqualTo("+14158586273");

        assertThat(phoneNumberJson)
            .hasJsonPathStringValue("@.countryCode");

        assertThat(phoneNumberJson)
            .extractingJsonPathStringValue("@.countryCode")
            .isEqualTo("US");

        assertThat(phoneNumberJson)
            .hasJsonPathStringValue("@.countryName");

        assertThat(phoneNumberJson)
            .extractingJsonPathStringValue("@.countryName")
            .isEqualTo("United States of America");

        assertThat(phoneNumberJson)
            .hasJsonPathStringValue("@.location");

        assertThat(phoneNumberJson)
            .extractingJsonPathStringValue("@.location")
            .isEqualTo("Novato");

        assertThat(phoneNumberJson)
            .hasJsonPathStringValue("@.carrier");

        assertThat(phoneNumberJson)
            .extractingJsonPathStringValue("@.carrier")
            .isEqualTo("AT&T Mobility LLC");

        assertThat(phoneNumberJson)
            .hasJsonPathStringValue("@.lineType");

        assertThat(phoneNumberJson)
            .extractingJsonPathStringValue("@.lineType")
            .isEqualTo("mobile");
    }

    @Test
    void PhoneNumberDeserializationTest() throws IOException {
        String phoneNumber = """
            {
                "valid": true,   
                "local_format": "4158586273",
                "intl_format": "+14158586273",
                "country_code": "US",
                "country_name": "United States of America",
                "location": "Novato",
                "carrier": "AT&T Mobility LLC",
                "line_type": "mobile"
            }
            """;

        assertThat(json.parse(phoneNumber))
            .isEqualTo(new PhoneNumber(
                true,   
                "4158586273",
                "+14158586273",
                "US",
                "United States of America",
                "Novato",
                "AT&T Mobility LLC",
                "mobile"
            ));

        PhoneNumber phoneNumberParsed = json.parseObject(phoneNumber);

        assertThat(phoneNumberParsed.valid()).isTrue();
        assertThat(phoneNumberParsed.localFormat()).isEqualTo("4158586273");
        assertThat(phoneNumberParsed.intlFormat()).isEqualTo("+14158586273");
        assertThat(phoneNumberParsed.countryCode()).isEqualTo("US");
        assertThat(phoneNumberParsed.countryName()).isEqualTo("United States of America");
        assertThat(phoneNumberParsed.location()).isEqualTo("Novato");
        assertThat(phoneNumberParsed.carrier()).isEqualTo("AT&T Mobility LLC");
        assertThat(phoneNumberParsed.lineType()).isEqualTo("mobile");
    }
}
