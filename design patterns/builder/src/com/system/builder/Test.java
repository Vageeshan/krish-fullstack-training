package com.system.builder;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 01:14 PM Friday
 **/
public class Test {
    public static void main(String[] args) {
        //passing only required args
        Student student = new Student.StudentBuilder(1, "Mark", "Antonoy").build();
        //passing required + optional args
        Student student2 = new Student.StudentBuilder(1, "Mike", "Tyson")
                .setAge(21)
                .setContactNumber("12345678")
                .setAddress("US")
                .build();
        System.out.println(student);
        System.out.println(student2);
    }
}
