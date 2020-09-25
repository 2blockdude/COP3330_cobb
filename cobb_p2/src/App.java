/*
Purpose: App class for BodyMassIndex
Name: Anthony Cobb
Date Created: 9/23/2020
Date Modified: 9/25/2020
*/
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
	private static Scanner input = new Scanner(System.in);
	private static boolean firstIteration = true;

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
			if(firstIteration) {
				System.out.println("Would you like to add someone to the BMI list? (y/n)");
				firstIteration = false;
			}
			else {
				System.out.println("Would you like to add another person to the BMI list? (y/n)");
			}

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
				continue;
			}
		}
	}

	private static double getUserHeight()
	{
		double userHeight;

		while(true) {
			System.out.print("Input the users height in inches: ");
			try {
				userHeight = input.nextDouble();
				if (userHeight < 0) {
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
			return userHeight;
		}
	}
	
	private static double getUserWeight()
	{
		double userWeight;

		while(true) {
			System.out.print("Input the users weight in pounds: ");
			try {
				userWeight = input.nextDouble();
				if (userWeight < 0) {
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
			return userWeight;
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
		System.out.println("Statistics");
		System.out.println("---------------------------------------------");
		System.out.println("Index\t|Height\t|Weight\t|BMI\t|Category");
		System.out.println("---------------------------------------------");
		
		//I did not use an enhanced for loop so I could have an index
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

			System.out.printf("%d\t:%.1f\t:%.1f\t:%.1f\t:%s\n", i + 1, h, w, s, c);
		}

		heightAverage = heightAverage / arraySize;
		weightAverage = weightAverage / arraySize;
		bmiAverage = bmiAverage / arraySize;
		
		System.out.println("---------------------------------------------");
		System.out.printf("Average\t:%.1f\t:%.1f\t:%.1f\n", heightAverage, weightAverage, bmiAverage);
	}
}
