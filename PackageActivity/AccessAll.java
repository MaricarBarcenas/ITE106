package com.program;

// Import the App class from the app package
import com.program.app.App;
// Import the Person class from the model package
import com.program.model.Person;
// Import the Helper class from the utils package
import com.program.utils.Helper;

public class AccessAll {
    public static void main(String[] args) {
        // Create a new Person object
        Person person = new Person("Alice", 30);
        
        // Use the Helper class to print the Person's info
        Helper.printPersonInfo(person);
    }
}