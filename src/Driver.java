import java.util.*;
/*
 * Isaac Hartzell
 * April 29th,2018
 * Final Project
 * This program demonstrates a general tree structure.
 */
public class Driver 
{

	public static void main(String[] arg)
	{
		Scanner scan = new Scanner(System.in);
		
		GeneralTree tree = new GeneralTree();
		
		System.out.println("Before getting to our main menu please create a president and manager for the office.");
		System.out.println("*Create president*");
		System.out.print("Enter an ID number for the president of the office.");
		int ID = scan.nextInt();
		System.out.print("Enter the name for the president of the office.");
		String name = scan.next();
		System.out.print("Enter where this person is located at.");
		String location = scan.next();
		
		Employee president = new Employee(ID,name,"President",location);
		
		tree.newRoot(president, null, null);
		
		System.out.println("*Create manager*");
		System.out.print("Enter an ID number for this manager of the office.");
		int managerID = scan.nextInt();
		System.out.print("Enter the name for this manager of the office.");
		String managerName = scan.nextLine();
		System.out.print("Enter where this manager is located at.");
		String managerLocation = scan.nextLine();
		
		Employee manager = new Employee(managerID,managerName,"Manager",managerLocation);
		
		tree.newLeftChild(manager);
		
		menu(tree);
	}
	
	public static char getChoice()
	{
		System.out.println("Enter Choice:");
		
		System.out.println("\t1 -- Quit");
		System.out.println("\t2 -- Insert");
		System.out.println("\t3 -- Remove");
		System.out.println("\t4 -- Print");
		System.out.println("\t5 -- Clear");
		
		System.out.print("Choice: ");
		
		Scanner userInput = new Scanner(System.in);
		
		return userInput.nextLine().charAt(0);
	}
	
	public static void menu(GeneralTree tree)
	{
		char choice = ' ';
		boolean isDone = false;
		Scanner userInput = new Scanner(System.in);
		String line;
		
		while (! isDone)
		{
			choice = getChoice();
			
			switch (choice)
			{
			case '1':				// Quit
				isDone = true;
				break;
			case '2':				// Insert
				System.out.println("Options for Inserting employees into the tree.");
				System.out.println("\tA --> New Manager" );
				System.out.print("\tB --> New worker");
				int index = -1;
				int counter = 0;
				char optionsChoice = userInput.next().charAt(0);
				
				if(optionsChoice == 'A' || optionsChoice == 'a')
				{
					
				}
				else if(optionsChoice =='B' || optionsChoice == 'b')
				{
					System.out.println("What is the ID number of the manager you wish to add this worker under?");
					int managerID = userInput.nextInt();
					
					Node[] tempArray = tree.getRoot().getChildren();
					
					for(Node n: tempArray)
					{
						if(n.getValue().getTitle().equals("Manager") && n.getValue().getId() == managerID)
						{
							index = counter;
						}
						else if (!n.getValue().getTitle().equals("Manager"))
						{
							System.out.println("Employee #" + n.getValue().getId() + "Only managers can be directly under the president.");
						}
						counter++;
						Node[] tempArray2 = n.getChildren();
						
						for(Node m: tempArray2)
						{
							if(!m.getValue().getTitle().equals("Worker"))
							{
								System.out.println("Employee #" + m.getValue().getId() + "Only workers allowed on this level");
								
							}
							if(m.getChildren().length != 0)
							{
								System.out.println("Workers shouldn't have anything below them.");
							}
						}
						
						System.out.println("*Create worker*");
						System.out.print("Enter an ID number for this worker of the office.");
						int workerID = userInput.nextInt();
						System.out.print("Enter the name for this worker of the office.");
						String workerName = userInput.nextLine();
						System.out.print("Enter where this worker is located at.");
						String workerLocation = userInput.nextLine();
						
						Employee worker = new Employee(workerID,workerName,"Worker",workerLocation);
						
						Node newNode = new Node(worker);
						
						tree.getRoot().getChild(index).insertFirst(newNode);
					}
				
					
				}
				break;
			case '3':				// Remove
				break;
			case '4':				// Print
				tree.print();
				break;
			case '5':				// Clear
				tree.clear();
				break;
			}

		}
		
	}
}