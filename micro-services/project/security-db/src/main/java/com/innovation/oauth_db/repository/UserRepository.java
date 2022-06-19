package com.innovation.oauth_db.repository;

import com.innovation.oauth_db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-17 06:16 pm Saturday
 **/
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
