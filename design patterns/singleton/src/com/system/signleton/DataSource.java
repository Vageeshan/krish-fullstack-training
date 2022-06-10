package com.system.signleton;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 09:18 AM Friday
 **/
public class DataSource {
    // double check locking that why we are using volatile
    private static volatile DataSource dataSource;

    private DataSource() {
        // why private? because we're enforcing others to not create an instance of this class
        // one instance per container (JVM)
        if (dataSource != null) {
            throw new RuntimeException("We are violating singleton rule");
        }
    }

    public static DataSource getDataSource() {
        // checking the object availability
        if (dataSource == null) {
            // thread safe
            synchronized (DataSource.class) {
                if (dataSource == null) {
                    dataSource = new DataSource();
                    System.out.println("Connection with the db established");
                }
            }
        }
        return dataSource;
    }
}
//EOL