/*
Purpose: Encrypts any string whos length is a multiple of four
Name: Anthony Cobb
Date Created: 9/7/2020
Date Modified: 9/8/2020
*/
public class Encrypter
{
	// Encrypts a string
	public String encrypt(String inputcode)
	{
		// An integer array with allocated size of 4 bytes
		int[] encryptarray = new int[inputcode.length()];

		// Goes through each character of given string and adds it to the array
		for(int i = 0; i < inputcode.length(); i++)
		{
			// Calls swap to get correct position to put the encrypted value
			int position = swap(i);

			encryptarray[position] = Character.getNumericValue(inputcode.charAt(i));
			
			// Changes value with encrypted value
			encryptarray[position] = (encryptarray[position] + 7) % 10;
		}
		

		return(changetostring(encryptarray));
	}

	// Obtains all values in a given integer array and puts it in a string
	private String changetostring(int[] encryptarray)
	{
		StringBuilder encryptbuild = new StringBuilder();
		
		// Adds each value of the array to the StringBuilder
		for (int j : encryptarray)
		{
			encryptbuild.append(j);
		}
		
		return(encryptbuild.toString());
	}

	// Obtains a value and returns the correct value for the encryption position
	// Ex: 1234 becomes 3412.
	private int swap(int place)
	{
		int calc = place % 4;
		
		if(calc < 2)
		{
			return(place + 2);
		}
		else
		{
			return(place - 2);
		}
	}
}
