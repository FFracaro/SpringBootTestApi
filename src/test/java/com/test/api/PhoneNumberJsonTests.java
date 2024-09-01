package com.test.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PhoneNumberJsonTests {
    
    @Test
    void MyFirstTest() {
        assertThat(1).isEqualTo(42);
    }
}
