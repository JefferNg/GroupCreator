import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GroupAssigner
	{
		static Scanner userInput = new Scanner(System.in);
		static int amount;
		static String[] groupHistory;
		static String[] groups = new String[amount];
		static ArrayList<String> students = new ArrayList<String>();
		
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
						+ "\nHow many groups would you like to have?");
				amount = userInput.nextInt();
				while(studentNames.hasNext())
					{
						String temp = studentNames.nextLine();
						String[] temps = temp.split(" ");
						students.add(temps[0] + " " + temps[1]);
						
						
					}
				System.out.println(students);
				
			}

		private static void assigningGroup()
			{
				int random = (int) (Math.random()*students.size() - 1);
				int[] history = new int[students.size()];
				
				for(int i = 0; i < groups.length; i++)
					{
						history[i] = random;
//						if(i == 0)
//							{
//								groups[i] = students.get(random);
//							}
//						else if(i > 0 && history[i - 1] != random)
//							{
								groups[i] = students.get(random);
//							}
//						else
//							{
//								i--;
//							}
						
					}
				
				
			}

		private static void avoidPairingTwoSameStudents()
			{
				// TODO Auto-generated method stub
				
			}

	}
