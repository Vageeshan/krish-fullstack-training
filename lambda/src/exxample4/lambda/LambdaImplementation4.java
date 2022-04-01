package exxample4.lambda;

import exxample4.regular.Greeting;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-01 03:37 pm Friday
 **/
public class LambdaImplementation4 {
    public static void main(String[] args) {
        Greeting greeting = (message) -> {
            // Multiple Statements
            String str1 = "Java is";
            return str1 + message;
        };
        System.out.println(greeting.greet("Awsomeeee!!!!!"));
    }
}
