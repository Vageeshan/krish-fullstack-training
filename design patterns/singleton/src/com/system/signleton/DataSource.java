package com.system.signleton;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 09:18 AM Friday
 **/
public class DataSource {
    private static DataSource dataSource;

    private DataSource(){
        // why private? because we're enforcing others to not create an instance of this class
        if (dataSource != null) {
            throw new RuntimeException("This is violating our rule");
        }
    }

    public static DataSource getInstance() {
        // checking the object availability
        if(dataSource == null) {
            dataSource = new DataSource();
            System.out.println("Connection with the db established");
        }
        return dataSource;
    }
}
//EOL