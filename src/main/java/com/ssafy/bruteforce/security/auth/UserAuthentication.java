package com.ssafy.bruteforce.security.auth;
import java.util.List;

import com.ssafy.bruteforce.dto.User;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserAuthentication extends UsernamePasswordAuthenticationToken{

    private static final long serialVersionUID = 1L;
    private User user;
    public UserAuthentication(String id, String pw, List authList, User user) {
        super(id, pw, authList);
        this.user = user;
    }
}