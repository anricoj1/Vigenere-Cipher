package lb4;
import java.util.Scanner;
import lb4.Vigenere;
import javax.swing.JOptionPane;

public class Execute
{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int cipher;
		String inputFile;
		String keyword;
		System.out.println("Example(Mac): /Users/username/Desktop/textfile.txt");
		System.out.println("Enter TextFile Name: ");
		inputFile = scanner.next();
		System.out.println("What is the keyword: ");
		keyword = scanner.next();
		System.out.println("To Encrypt Press (1) to Decrypt Press (2): ");
		cipher = scanner.nextInt();
		scanner.close();
		
		Vigenere vigenereCipher = new Vigenere(inputFile, keyword);
		
		vigenereCipher.VigenereCipher(cipher);
	}

}
