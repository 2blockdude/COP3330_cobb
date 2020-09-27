/*
Purpose: Decrypts any string whos length is a multiple of four
Name: Anthony Cobb
Date Created: 9/7/2020
Date Modified: 9/13/2020
*/
import java.lang.Math;
public class Decrypter
{
	public String decrypt(String inputCode)
	{
		int[] inputCodeArray = new int[inputCode.length()];

		for(int i = 0; i < inputCode.length(); i++)
		{
			/*
			   I am unsure if I should initialize this integer within the for loop or outside.
			*/
			int position = decryptPosition(i);
			inputCodeArray[position] = Character.getNumericValue(inputCode.charAt(i));
			inputCodeArray[position] = ((inputCodeArray[position] - 7) + 10) % 10;
		}
		

		return(convertArrayToString(inputCodeArray));
	}

	/*
	   Converting an array to string using a built in java method did not format how I wanted.
	   This allows each element of the array to be added to a single string without brackets or commas.
	*/
	private String convertArrayToString(int[] inputCodeArray)
	{
		StringBuilder buildDecryptString = new StringBuilder();
		
		for (int j : inputCodeArray)
		{
			buildDecryptString.append(j);
		}
		
		return(buildDecryptString.toString());
	}

	private int decryptPosition(int position)
	{
		/*
		   I could put the entire formula in one integer, however,
		   I wanted to try and make it clearer to read.
		   I am unsure if that is good practice.
		*/
		int cycle = position / 2;
		int modCycle = cycle % 2;
		double state = Math.pow(-1, modCycle);
		int newPosition = position + ((int)state * 2);

		return newPosition;
	}
}
