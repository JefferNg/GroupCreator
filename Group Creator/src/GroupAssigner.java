import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GroupAssigner
	{
		static Scanner userInput = new Scanner(System.in);
		static int amount;
		static String[] groupHistory;
		static String[] groups;
		static ArrayList<String> students = new ArrayList<String>();
		
		public static void main(String[] args) throws IOException
			{
				amountPerGroup();
				assigningGroup();
				//avoidPairingTwoSameStudents();
				
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
						students.add(temps[0] + " " + temps[1] + " ");
						
						
					}
				System.out.println(students);
				
			}

		private static void assigningGroup()
			{
				int random = 0;
				int[] history = new int[students.size()];
				groups = new String[amount];
				int perGroup = students.size() / amount;
				
				for(int i = 0; i < amount; i++)
					{
						for(int j = 0; j <= perGroup; j++)
							{
								random = (int)(Math.random()*students.size());
								
								if(j == 0)
									{
										history[0] = random;
										groups[0] = students.get(random);	
									}
								else if(j > 0 && random != history[j - 1])
									{
										groups[i] += students.get(random);
										history[j] = random;
									}
								else if(random == history[j-1])
									{
										j--;
									}
							}
						System.out.println(groups[i]);
					}
				System.out.println(perGroup);
				System.out.println(random);
				System.out.println(history[0]);
				System.out.println(groups[0]);
			}

		private static void avoidPairingTwoSameStudents()
			{
				// TODO Auto-generated method stub
				
			}

	}
