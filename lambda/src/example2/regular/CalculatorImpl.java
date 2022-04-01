package example2.regular;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-01 02:46 pm Friday
 **/
public class CalculatorImpl implements Calculator {
    @Override
    public int findSum(int number) {
        return number + number;
    }

    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        System.out.println(calculator.findSum(10));
    }
}
