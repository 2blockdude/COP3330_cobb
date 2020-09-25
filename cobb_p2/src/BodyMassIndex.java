/*
Purpose: Calculates BMI score based on height and weigth.
Name: Anthony Cobb
Date Created: 9/23/2020
Date Modified: 9/25/2020
*/
public class BodyMassIndex
{
	private double height;
	private double weight;
	private double score;
	private String category;

	public BodyMassIndex(double height, double weight)
	{
		// Redundant value check to test shorthand if statments. Looks cool.
		this.height = (height < 0) ? null : height;
		this.weight = (weight < 0) ? null : weight;
		this.score = 703 * weight / (height * height);
		setCategory();
	} 

	public double getHeight()
	{
		return height;
	}

	public double getWeight()
	{
		return weight;
	}

	public double getScore()
	{
		return score;
	}

	public String getCategory()
	{
		return category;
	}

	private void setCategory()
	{
		if(score < 18.5) {
			category = "Underweight";
		}
		else if(score < 25) {
			category = "Normal weight";
		}
		else if(score < 30) {
			category = "Overweight";
		}
		else {
			category = "Obesity";
		}
	}
}
