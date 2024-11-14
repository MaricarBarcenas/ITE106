// part of the 'program' package
package com.program.app;

// to use/access variables/attributes and methods/functions of the Class 'Helper'
import com.program.utils.Helper;

public class App {
    // built-in method, not user-defined
    public static void main(String[] args) {
        // new object 'person' instantiated from the Class 'Person'. Not passed as argument because 'main' method has it's own parameter which is 'String[]'
        Person person = new Person("Alice", 30);
        // uses the 'printPersonInfo()' method of the class 'Person' using the object 'person'
        Helper.printPersonInfo(person);
    }
}