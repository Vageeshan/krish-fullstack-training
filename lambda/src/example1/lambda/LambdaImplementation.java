package example1.lambda;

import example1.regular.Printable;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-01 02:39 pm Friday
 **/
public class LambdaImplementation {
    public static void main(String[] args) {
        String name = "Krish iyya";
        Printable printable = ()-> {
            // No param
            System.out.println("Hello "+name);
        };
        printable.printName();
    }
}
