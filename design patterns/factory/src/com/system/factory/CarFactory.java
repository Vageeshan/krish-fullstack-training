package com.system.factory;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 10:38 AM Friday
 **/
public class CarFactory {
    public Car createCar(BrandEnum brand) {
        switch (brand) {
            case LAMBORGHINI:
                return new SportsCar();
            case BENZ:
                return new RoyalCar();
            case TOYOTA:
                return new LowBudgetCar();
            default:
                return null;
        }
    }
}
