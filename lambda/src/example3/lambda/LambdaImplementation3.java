package example3.lambda;

import example3.regular.AreaCalculator;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-01 03:34 pm Friday
 **/
public class LambdaImplementation3 {
    public static void main(String[] args) {
        // multiple param
        AreaCalculator areaCalculator = (height, width) -> height * width;
        System.out.println(areaCalculator.findArea(10, 20));
    }
}
