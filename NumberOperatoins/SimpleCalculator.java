import java.util.Scanner;

public class SimpleCalculator
{
	public static void main(String[]args) {
	Scanner scanner = new Scanner (System.in);
	System.out.print ("Enter First Number: ");
	int num1 = scanner.nextInt();
	System.out.print("Enter Second Number: ");
	int num2 = scanner.nextInt();
	int div = num1 / num2;
	int add = num1 + num2;
	int mul = num1 * num2;
	int sub = num1 - num2;
	int mod = num1 % num2;
	System.out.println("ADDITION: " + add);
	System.out.println("SUBTRACTION: " + sub);
	System.out.println("MULTIPLICATION: " + mul);
	System.out.println("DIVISION: " + div);
	System.out.println("MODULO: " + mod);
	}
}