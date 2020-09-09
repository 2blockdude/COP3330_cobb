/*
Purpose: Decrypts any string whos length is a multiple of four
Name: Anthony Cobb
Date Created: 9/7/2020
Date Modified: 9/8/2020
*/
public class Decrypter
{
	// Encrypts a string
	public String decrypt(String inputcode)
	{
		// An integer array with allocated size of 4 bytes
		int[] decryptarray = new int[inputcode.length()];

		// Goes through each character of given string and adds it to the array
		for(int i = 0; i < inputcode.length(); i++)
		{
			// Calls swap to get correct position to put the decrypted value
			int position = swap(i);

			decryptarray[position] = Character.getNumericValue(inputcode.charAt(i));
			
			// Changes value with decrypted value
			decryptarray[position] = ((decryptarray[position] - 7) + 10) % 10;
		}
		

		return(changetostring(decryptarray));
	}

	// Obtains all values in a given integer array and puts it in a string
	private String changetostring(int[] decryptarray)
	{
		StringBuilder decryptbuild = new StringBuilder();
		
		// Adds each value of the array to the StringBuilder
		for (int j : decryptarray)
		{
			decryptbuild.append(j);
		}
		
		return(decryptbuild.toString());
	}

	// Obtains a value and returns the correct value for the decryption position
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
