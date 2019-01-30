import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GroupAssigner
	{
		static Scanner userInput = new Scanner(System.in);
		static int amount;
		static String[] firstGroups;
		static String[] secondGroups;
		static ArrayList<String> students = new ArrayList<String>();
		static ArrayList<String> forFirstProject = new ArrayList<String>();
		static ArrayList<String> forSecondProject = new ArrayList<String>();
		
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
						students.add(temps[0] + " " + temps[1] + " ");
						forFirstProject.add(temps[0] + " " + temps[1] + " ");
						forSecondProject.add(temps[0] + " " + temps[1] + " ");
						
						
					}
				System.out.println(students);
				
			}

		private static void assigningGroup()
			{
				int random = 0;
				int[] history = new int[students.size()];
				firstGroups = new String[amount];
				int perGroup = students.size() / amount;
				int extras = students.size() % amount;
				
				for(int i = 0; i < amount; i++)
					{
						for(int j = 0; j < perGroup; j++)
							{
								random = (int)(Math.random()*forFirstProject.size());
								
								if(j == 0)
									{
										history[0] = random;
										firstGroups[i] = forFirstProject.get(random);	
										forFirstProject.remove(random);
									}
								else if(random != history[j - 1] || !firstGroups[i].contains(forFirstProject.get(random)))
									{
										firstGroups[i] += forFirstProject.get(random);
										history[j] = random;
										forFirstProject.remove(random);
									}
								else if(random == history[j-1] || firstGroups[i].contains(forFirstProject.get(random)))
									{
										j--;
									}
								
								
							}
												
						
					}
				
				for(int i = 0; i < extras; i++)
					{		
						firstGroups[i] += forFirstProject.get(0);
						forFirstProject.remove(0);	
					}
				
				System.out.println("For project 1:");
				
				for(int i = 1; i <= amount; i++)
					{
						System.out.println("Group " + i + ": " + firstGroups[i - 1]);
					}
				
				System.out.println(perGroup);
				System.out.println(extras);
				System.out.println();
			}

		private static void avoidPairingTwoSameStudents()
			{
				int random = 0;
				int[] history = new int[students.size()];
				secondGroups = new String[amount];
				int perGroup = students.size() / amount;
				int extras = students.size() % amount;
				
				for(int i = 0; i < amount; i++)
					{
						for(int j = 0; j < perGroup; j++)
							{
								random = (int)(Math.random()*forSecondProject.size());
								
								if(j == 0)
									{
										history[0] = random;
										secondGroups[i] = forSecondProject.get(random);	
										forSecondProject.remove(random);
									}
								else if(random != history[j - 1] || !secondGroups[i].contains(forSecondProject.get(random)))
									{
										secondGroups[i] += forSecondProject.get(random);
										history[j] = random;
										forSecondProject.remove(random);
									}
								else if(random == history[j-1] || secondGroups[i].contains(forSecondProject.get(random)))
									{
										j--;
									}
								
								
							}
						
						
					}
				
				
				
				
				for(int i = 0; i < extras; i++)
					{	
						secondGroups[i] += forSecondProject.get(0);
						forSecondProject.remove(0);
					}
				
				System.out.println("For project 2:");
				
				for(int i = 1; i <= amount; i++)
					{
						System.out.println("Group " + i + ": " + secondGroups[i - 1]);
					}
				
			}

	}
