package com.test.patipan.services;

import com.test.patipan.entity.User;
import com.test.patipan.model.Information;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;


public interface UserRegistrationService {

    void saveUser(User user) throws UsernameNotFoundException;

    int getMemberTypeBySalary(int salary);

    String generateReferenceCode(Date createDate, String phoneNumber);

    Information getInformation();

}
