package com.ssafy.bruteforce.security.provider;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.bruteforce.dto.ResultJson;
import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.security.auth.UserAuthentication;
import com.ssafy.bruteforce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id= authentication.getName();
        String password = authentication.getCredentials().toString();

        ResultJson result = userService.login(id, password);

        if(!result.getState().equals("success"))
        {
            return null;
        }

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        User user = (User)(result.getContents());

        final String ADMIN = "ROLE_ADMIN";
        final String USER = "ROLE_USER";
        final String ROLE = user.getbAdmin() ? ADMIN : USER;
        grantedAuthorityList.add(new SimpleGrantedAuthority(ROLE));

        return new UserAuthentication(id, ROLE, grantedAuthorityList, user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}