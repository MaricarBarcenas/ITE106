package project;

public class Overloaded {
	public static void main(String[] args) {
		OverloadedClass OC = new OverloadedClass();
		// different parameters leads to different methods/constructor being run
		OC.giveValue(true);
		OC.giveValue("HOTDOG");
		OC.giveValue(123456890);
		OC.giveValue('A');
		OC.giveValue(12.81f);
	}
}