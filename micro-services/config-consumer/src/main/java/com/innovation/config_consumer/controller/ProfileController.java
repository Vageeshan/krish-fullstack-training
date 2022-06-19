package com.innovation.config_consumer.controller;

import com.innovation.config_consumer.model.MemberProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 06:51 am Saturday
 **/

@RestController
public class ProfileController {

    @Autowired
    private MemberProfileConfiguration memberProfileConfiguration;

    @GetMapping("/profile")
    public MemberProfileConfiguration getMemberProfileConfiguration() {
        // see in application.yml file
        return memberProfileConfiguration;
    }
}
