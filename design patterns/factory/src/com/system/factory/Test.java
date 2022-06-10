package com.system.factory;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 10:45 AM Friday
 **/
public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car sportsCar = carFactory.createCar(BrandEnum.LAMBORGHINI);
        Car royal = carFactory.createCar(BrandEnum.BENZ);
        Car low = carFactory.createCar(BrandEnum.TOYOTA);
        sportsCar.getCar();
        royal.getCar();
        low.getCar();
    }
}
