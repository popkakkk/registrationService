package com.test.patipan.model;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class ErrorResponse {

    public ErrorResponse(String message) {
        this.message = message;
    }

    private String message;
    private Date timestamp = Calendar.getInstance().getTime();
}
