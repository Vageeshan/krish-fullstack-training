package example1.regular;
/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-01 02:37 pm Friday
 **/
public class PrintImpl implements Printable {
    String name = "Krish iyya";
    @Override
    public void printName() {
        System.out.println("Hello "+name);
    }

    public static void main(String[] args) {
        PrintImpl studentImpl = new PrintImpl();
        studentImpl.printName();
    }
}
