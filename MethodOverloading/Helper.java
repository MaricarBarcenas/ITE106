package project;

// METHOD OVERLOADING is SIMPLY a multiple METHODS or commonly multiple CONSTRUCTORS with the SAME NAME but different PARAMETERS
public class OverloadedClass {
	// here we have the first method with parameter 'String'
	public void giveValue(String text) {
		System.out.println("You gave me a text: " + text);
	}
	// here we have the first method with parameter 'int'
	public void giveValue(int number) {
		System.out.println("You gave me a number: " + number);
	}
	// here we have the first method with parameter 'boolean'
	public void giveValue(boolean bool) {
		System.out.println("You gave me a boolean: " + bool);
	}
	// here we have the first method with parameter 'char'
	public void giveValue(char character) {
		System.out.println("You gave me a character: " + character);
	}
	// here we have the first method with parameter 'float'
	public void giveValue(float decimal) {
		System.out.println("You gave me a decimal: " + decimal);
	}
	// but they all have the SAME METHOD NAME. Hence, METHOD OVERLOADING
	// which will run? the method that will run is BASED on what the ARGUMENT passed unto the method's PARAMETER
}