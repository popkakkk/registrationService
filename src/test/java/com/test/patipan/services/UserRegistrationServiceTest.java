package com.test.patipan.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@ExtendWith(MockitoExtension.class)
class UserRegistrationServiceTest {
    private UserRegistrationService userRegistrationService;

    @BeforeEach
    void init() {
        userRegistrationService = new UserRegistrationServiceImpl();
    }


    @Test
    void generateReferenceCode() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        String refCode = userRegistrationService.generateReferenceCode(formatter.parse("12122012"), "0801234567");

        Assertions.assertEquals("121220124567", refCode);
    }
}