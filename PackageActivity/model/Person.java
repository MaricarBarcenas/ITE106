// part of the 'program' package
package com.example.model;

public class Person {
    // cannot be access 
    private String name
    private int age;

    // initialize variables
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // to get/retrieve variables/attributes of INSTANTIATED OBJECTS, not this CLASS
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}