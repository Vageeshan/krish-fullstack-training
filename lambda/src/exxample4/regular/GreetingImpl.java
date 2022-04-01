package exxample4.regular;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-01 03:07 pm Friday
 **/
public class GreetingImpl implements Greeting {

    @Override
    public String greet(String message) {
        String str1 = "Java is";
        return str1 + message;
    }
    public static void main(String[] args) {
        GreetingImpl greeting = new GreetingImpl();
        System.out.println(greeting.greet("Awsome"));
    }
}
