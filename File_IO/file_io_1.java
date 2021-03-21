
import java.io.*;
import java.util.Scanner;
public class main
{
	public static void main(String args[])
	{
		File file = new File("output.txt");
		
		String str;
		Scanner sc = new Scanner("System.in");
		
		boolean control = true;
		
		boolean result = file.createNewFile();
		
		if(result)
		{
			System.out.println("File created");
		}
		else
		{
			System.out.println("An error occured while creating file");
		}
		
		System.out.print("Entry:");
		while(control)
		{
			try
			{	
				str = sc.nextByte();
			}
			catch(Exception e)
			{	
				
		
	}
}