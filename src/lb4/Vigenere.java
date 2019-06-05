package lb4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;



public class Vigenere 
{
	private String textFile;
	private String keyword;
	private int length;
	public char[] alphabet = {
		'a','b','c','d','e','f','g','h','i','j','k','l','m',
		'n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public Vigenere(String textFile, String keyword)
	{
		this.textFile = textFile;
		this.keyword = keyword;
		length = keyword.length();
	}
	
	public void VigenereCipher(int cipher)
	{
		if (cipher == 1)
		{
			encrypt();
		}
		else if (cipher == 2)
		{
			decrypt();
		}
		else
		{
			System.out.println("Error: not defined.");
		}
	}
	
	private void encrypt()
	{
		System.out.println("Encrypting to same filelocation using keyword: " + keyword);
		int a = -1;
		char encryptA;
		try
		{
			FileReader fileReader = new FileReader(textFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter writer = new FileWriter((textFile + "_encrypted.txt"), false);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			int index = 0;
			char[] keyArr = keyword.toLowerCase().toCharArray();
			
			while ((a = bufferedReader.read()) != -1)
			{
				char character = (char)a;
				if (Character.isLetter(character))
				{
					//encrypt letters to write them to the output file
					char key = keyArr[index];
					if(Character.isLowerCase(character))
					{
						encryptA = alphabet[(alphabetIndex(key) + alphabetIndex(character)) % alphabet.length];
					}
					else
					{
						character = Character.toLowerCase(character);					
						encryptA = alphabet[(alphabetIndex(key) + alphabetIndex(character)) % alphabet.length];
						encryptA = Character.toUpperCase(encryptA);
					}
					bufferedWriter.write(encryptA);
					index = (index + 1) % keyArr.length;
				}
				else
				{
					//write non letter characters to the output file
					bufferedWriter.write(character);
					System.out.println("______");
				}
			}
			bufferedWriter.close();
			bufferedReader.close();
			System.out.println();
			System.out.println("Encryption Complete!");
			System.out.println("Created new file in same file location");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " + textFile + "does not exist.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void decrypt()
	{
		System.out.println("Decrypting to same file location using keyword: " + keyword);
		int d = -1;
		char decryptD;
		try
		{
			FileReader fileReader = new FileReader(textFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter writer = new FileWriter((textFile + "_decrypted.txt"), false);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			int index = 0;
			char[] keyArr = keyword.toLowerCase().toCharArray();
			
			while ((d = bufferedReader.read()) != -1)
			{
				char character = (char)d;
				if (Character.isLetter(character))
				{
					
					char key = keyArr[index];
					if(Character.isLowerCase(character))
					{
						decryptD = alphabet[(alphabetIndex(character) - alphabetIndex(key) + alphabet.length) % alphabet.length];
					}
					else
					{
						character = Character.toLowerCase(character);					
						decryptD = alphabet[(alphabetIndex(character) - alphabetIndex(key) + alphabet.length) % alphabet.length];
						decryptD = Character.toUpperCase(decryptD);
					}
					bufferedWriter.write(decryptD);
					index = (index + 1) % keyArr.length;
				}
				else
				{
					
					bufferedWriter.write(character);
					System.out.println("_______");
				}
			}
			bufferedWriter.close();
			bufferedReader.close();
			System.out.println();
			System.out.println("Decryption Complete!");
			System.out.println("Created new file in same file location");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " + textFile + "does not exist.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private int alphabetIndex(char c)
	{
		for (int i = 0; i < alphabet.length; i++)
		{
			if(c == alphabet[i])
			{
				return i;
			}
		}
		return -1;
	}

}
