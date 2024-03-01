/**
 * A suggested solution for assignment 2, it might not be the best though!
 * @author Fadi Wedyan
 * 
 */
package cpsc24500.a2;

import java.util.Scanner;

public class TaxCalculator {
	
	public static int calculateTax(int income) {
		int firstBracket = 4000;
		int secondBracket = firstBracket+1500;
		int thirdBracket = secondBracket+ 28000;
				
		// First bracket, tax free
		int tax = 0;
		if (income <= firstBracket) {
			return tax;
		} 
		// Second bracket, 10% on income higher that first bracket
		tax += (int)((Math.min(income, secondBracket) -firstBracket) * 0.1);
		if (income <= secondBracket) {	
			return tax;
		}
		// Third bracket, 20% on income higher than second bracket
		tax += (int)((Math.min(income, thirdBracket) -secondBracket) * 0.2);		
		if (income <= thirdBracket) {
			return tax;
		} 
		// fourth bracket, 40% on income higher than third bracket
		tax += (int) ((income- thirdBracket) * 0.40);
		return tax;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Welcome to Javaland tax system");
		System.out.print("Enter your full name: ");
		String name = sc.nextLine();
		System.out.print("Enter your income: ");
		int income = (int) sc.nextDouble();
		if (income < 0) {
			System.out.println("Invalid input, income should be zero or more");
			System.exit(0);
		}
		int tax = calculateTax(income);
		System.out.println("Full Name: " + name);
		System.out.println("Income: J$" + income);
		System.out.println("Income Tax: J$" + tax);
		sc.close();
	}
}

