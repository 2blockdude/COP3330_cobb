/*
Purpose: Encrypts any string whos length is a multiple of four
Name: Anthony Cobb
Date Created: 9/7/2020
Date Modified: 9/10/2020
*/
public class Encrypter
{
	public String encrypt(String inputCode)
	{
		int[] inputCodeArray = new int[inputCode.length()];

		for(int i = 0; i < inputCode.length(); i++)
		{
			int position = swapNumbers(i);
			inputCodeArray[position] = Character.getNumericValue(inputCode.charAt(i));
			inputCodeArray[position] = (inputCodeArray[position] + 7) % 10;
		}
		

		return(convertArrayToString(inputCodeArray));
	}

	/*
	Converting an array to string using a built in java
	method did not format how the way I wanted.
	This allows each element of the array to be added to
	a single string without brackets or commas.
	*/
	private String convertArrayToString(int[] inputCodeArray)
	{
		StringBuilder buildEncryptString = new StringBuilder();
		
		for (int j : inputCodeArray)
		{
			buildEncryptString.append(j);
		}
		
		return(buildEncryptString.toString());
	}

	private int swapNumbers(int place)
	{
		int calculate = place % 4;
		
		if(calculate < 2)
		{
			return(place + 2);
		}
		else
		{
			return(place - 2);
		}
	}
}
