package example2.lambda;

import example2.regular.Calculator;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-01 02:47 pm Friday
 **/
public class LambdaImplementation2 {
    public static void main(String[] args) {
        // Single param
        Calculator calculator = number -> number + number;
        System.out.println(calculator.findSum(10));
    }
}
