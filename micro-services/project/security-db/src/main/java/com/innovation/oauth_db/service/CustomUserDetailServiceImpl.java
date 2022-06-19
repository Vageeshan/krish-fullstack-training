package com.innovation.oauth_db.service;

import com.innovation.oauth_db.model.CustomAuthUserDetail;
import com.innovation.oauth_db.model.User;
import com.innovation.oauth_db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-17 06:15 pm Saturday
 **/
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("This credentials not found with our records"));

        // spring don't know about user, its only know UserDetails, that's why we're dealing with userDetails
        UserDetails userDetails = new CustomAuthUserDetail(user.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
