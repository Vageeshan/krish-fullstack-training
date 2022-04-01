package example3.regular;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-01 02:54 pm Friday
 **/
public class AreaImpl implements AreaCalculator {
    @Override
    public int findArea(int height, int width) {
        return height * width;
    }

    public static void main(String[] args) {
        AreaImpl areaImpl = new AreaImpl();
        System.out.println(areaImpl.findArea(10, 20));
    }
}
