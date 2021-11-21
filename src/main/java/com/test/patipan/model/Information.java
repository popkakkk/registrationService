package com.test.patipan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer salary;
    private String userType;
    private Date createDate;
    private String referenceCode;
}
