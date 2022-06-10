package com.system.signleton;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 09:22 AM Friday
 **/
public class Test {
    public static void main(String[] args) {
        DataSource dataSource = DataSource.getInstance();
        if (dataSource != null) {
            System.out.println(dataSource);
        }
    }
}
//EOL