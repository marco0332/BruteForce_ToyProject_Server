
package com.ssafy.bruteforce.security.config;
import com.ssafy.bruteforce.security.provider.AuthProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthProvider authProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers("/api/login","/api/addUser", "/api/existsById","/error**").permitAll()
                .antMatchers("auth/admin/**").hasRole("ADMIN")
                .antMatchers("/auth/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();

        http.formLogin()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .usernameParameter("id")
                .passwordParameter("pw");
            
        http.logout()  
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        http.authenticationProvider(authProvider);
    }

}