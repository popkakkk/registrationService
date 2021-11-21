package com.test.patipan.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 64)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 64)
    private String firstName;
    @Column(nullable = false, length = 64)
    private String lastName;
    @Column(nullable = false, length = 10)
    private String phoneNumber;
    @Column(nullable = false, length = 10)
    private Integer salary;
    @Column(nullable = false,length = 1)
    private Integer userTypeCode;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false, length = 12)
    private String referenceCode;


}
