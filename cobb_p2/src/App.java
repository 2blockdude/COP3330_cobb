/*
Purpose: App class for BodyMassIndex
Name: Anthony Cobb
Date Created: 9/23/2020
Date Modified: 9/26/2020
*/
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args)
	{
		ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();
	
		while (moreInput()) {
			double height = getUserHeight();
			double weight = getUserWeight();
	
			BodyMassIndex bmi = new BodyMassIndex(height, weight);
			bmiData.add(bmi);
	
			displayBmiInfo(bmi);
		}
	
		displayBmiStatistics(bmiData);
	}

	private static boolean moreInput()
	{
		while(true) {
			System.out.println("Would you like to add someone to the BMI list? (y/n)");
			System.out.print(": ");

			String userOption = input.nextLine();
			
			if(userOption.equalsIgnoreCase("y")) {
				System.out.println();
				return true;
			}
			else if(userOption.equalsIgnoreCase("n")) {
				return false;
			}
			else {
				System.out.println("Invalid Option!");
			}
		}
	}

	private static double getUserHeight()
	{
		return getUserInputPositiveDouble("Input the users height in inches: ");
	}
	
	private static double getUserWeight()
	{
		return getUserInputPositiveDouble("Input the users weight in pounds: ");
	}

	private static double getUserInputPositiveDouble(String prompt)
	{
		double userInput;

		while(true) {
			System.out.print(prompt);
			try {
				userInput = input.nextDouble();
				if (userInput < 0) {
					System.out.println("Input must be a positive value!");
					continue;
				}
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Invalid Input!");
				input.nextLine();
				continue;
			}

			input.nextLine();
			return userInput;
		}
	}

	private static void displayBmiInfo(BodyMassIndex bmi)
	{
		// Unsure if println to make a new line is better than using \n
		System.out.println();
		System.out.println("Added user to BMI list.");
		System.out.println("Height:" + "\t  " + bmi.getHeight());
		System.out.println("Weight:" + "\t  " + bmi.getWeight());
		System.out.printf("BMI:\t  %.1f\n", bmi.getScore());
		System.out.println("Category: " +  bmi.getCategory());
		System.out.println();
	}

	private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
	{
		double heightAverage = 0;
		double weightAverage = 0;
		double bmiAverage = 0;
		int arraySize = bmiData.size();

		System.out.println();
		System.out.println("BMI Statistics");
		System.out.println("---------------------------------------------");
		System.out.println("User\t|Height\t|Weight\t|BMI\t|Category");
		System.out.println("---------------------------------------------");
		
		//I did not use an enhanced for loop in favor of an index
		for(int i = 0; i < bmiData.size(); i++) {
			/*
			   Made four variables to make things appear cleaner.
			   I am unsure if this is good practice.
			*/
			double h = bmiData.get(i).getHeight();
			double w = bmiData.get(i).getWeight();
			double s = bmiData.get(i).getScore();
			String c = bmiData.get(i).getCategory();

			heightAverage += h;
			weightAverage += w;
			bmiAverage += s;

			System.out.printf("User %d\t|%.1f\t|%.1f\t|%.1f\t|%s\n", i + 1, h, w, s, c);
		}

		heightAverage = heightAverage / arraySize;
		weightAverage = weightAverage / arraySize;
		bmiAverage = bmiAverage / arraySize;
		
		System.out.println("---------------------------------------------");
		System.out.printf("Average\t|%.1f\t|%.1f\t|%.1f\n", heightAverage, weightAverage, bmiAverage);
	}
}
