package com.system.builder;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 01:07 PM Friday
 **/
public class Student {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String contactNumber;
    private final String address;

    public Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.firstName = studentBuilder.firstName;
        this.lastName = studentBuilder.lastName;
        this.age = studentBuilder.age;
        this.contactNumber = studentBuilder.contactNumber;
        this.address = studentBuilder.address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private final int id;
        private final String firstName;
        private final String lastName;
        private int age;
        private String contactNumber;
        private String address;

        public StudentBuilder(int id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
