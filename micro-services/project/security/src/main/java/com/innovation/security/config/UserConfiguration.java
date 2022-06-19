package com.innovation.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 02:31 pm Saturday
 **/

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("vagee")
                .password(passwordEncoder.encode("vageesh"))
                .roles("USER", "ADMIN", "MANAGER")
                .authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE")
                .and()
                .withUser("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .authorities("CAN_READ", "CAN_WRITE");
    }
}
