package com.test.patipan.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserRegistrationServiceTest {

    @Autowired
   private UserRegistrationServiceImpl userRegistrationServiceImpl;

    @Test
    void generateReferenceCode() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        String refCode = userRegistrationServiceImpl.generateReferenceCode(formatter.parse("12122012"), "0801234567");

        Assertions.assertEquals("121220124567", refCode);
    }
}