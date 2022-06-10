package com.system.factory;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 10:38 AM Friday
 **/
public class LowBudgetCar implements Car{
    @Override
    public void getCar() {
        System.out.println("This is from low-budget car");
    }
}
