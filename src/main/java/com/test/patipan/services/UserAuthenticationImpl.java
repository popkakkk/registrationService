package com.test.patipan.services;

import com.test.patipan.entity.User;
import com.test.patipan.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationImpl implements UserAuthentication {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;



    @Override
    public String createToken(User user) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        return jwtTokenUtil.generateToken(userDetails);
    }


    @Override
    public String authenticationToken(User user) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            return createToken(user);
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
    }
}
