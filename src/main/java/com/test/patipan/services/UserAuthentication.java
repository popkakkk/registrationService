package com.test.patipan.services;

import com.test.patipan.entity.User;

public interface UserAuthentication {

    String createToken(User user);

    String authenticationToken(User user) throws Exception;
}
