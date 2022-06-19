package com.innovation.session_one.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 04:02 am Saturday
 **/

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greetings() {
        return "hello Java";
    }
}
