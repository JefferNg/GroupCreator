import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class GroupAssigner
	{
		static Scanner userInput = new Scanner(System.in);
		static int amount;
		static String[] groupHistory;
		static String[] groups;
		
		public static void main(String[] args) throws IOException
			{
				amountPerGroup();
				assigningGroup();
				avoidPairingTwoSameStudents();
				
			}

		private static void amountPerGroup() throws IOException
			{
				Scanner studentNames = new Scanner(new File("StudentList.txt"));
				System.out.println("Welcome to the Group Creator 2020"
						+ "\nHow many people do you want per group?");
				amount = userInput.nextInt();
				
				
				
			}

		private static void assigningGroup() throws IOException
			{
				
				
				
				
				
			}

		private static void avoidPairingTwoSameStudents()
			{
				// TODO Auto-generated method stub
				
			}

	}
