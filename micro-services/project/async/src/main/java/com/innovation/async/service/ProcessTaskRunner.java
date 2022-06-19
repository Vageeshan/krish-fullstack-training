package com.innovation.async.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 10:15 am Sunday
 **/
public class ProcessTaskRunner implements CommandLineRunner {
    @Autowired
    private RentProcessService rentProcessService;

    @Override
    public void run(String... args) {
        if (args.length > 0) {
            System.out.println("Task is running with arguments");
            if (rentProcessService.validateDL(args[0])) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        } else {
            System.out.println("Task is running without arguments");
        }
    }
}
