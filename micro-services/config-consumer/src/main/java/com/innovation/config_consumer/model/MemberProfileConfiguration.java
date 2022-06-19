package com.innovation.config_consumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 06:47 am Saturday
 **/

@Component
public class MemberProfileConfiguration {

    @Autowired
    private Environment environment;

    public String getDefaultModel(){
        return environment.getProperty("vehicle.default.model");
    }

    public String getMinRentPeriod(){
        return environment.getProperty("member.rent.min");
    }
}
