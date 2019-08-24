package Using_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
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
		//Scanner object for input.
		Scanner userInput = new Scanner(System.in);
		//tree object.
		GeneralTree tree = new GeneralTree();
		//An array list to store all employees which will be useful for checking for duplicates.
		ArrayList<Employee>addEmployees = new ArrayList<Employee>();
		//I'm forcing the user to enter the president into the root node.
		System.out.println("Before getting to our main menu please create a president and manager for the office.");
		System.out.println("*Create president*\n");
		
		System.out.print("Enter an ID number for the president of the office.");
		int ID = userInput.nextInt();
		userInput.nextLine();
		
		System.out.print("Enter the name for the president of the office.");
		String name = userInput.nextLine();
		
		System.out.print("Enter where this person is located at.");
		String location = userInput.nextLine();
		//Creates president object.
		Employee president = new Employee(ID,name,"President",location);
		//Adds the president to my arrayList for storing all employees.
		addEmployees.add(president);
		//Creates the president as the root node which has no first or sibling argument hence the null null.
		tree.newRoot(president, null, null);
		//Call for the menu which does the heart of the program. I pass it userInput and most of my methods the Scanner object
		//so I don't have to have scanners everywhere.
		menu(tree,userInput,addEmployees);
	}
	//Prints out the menu and retuns the user's choice back to the caller method.
	public static char getChoice(Scanner userInput)
	{
		System.out.println("Enter Choice:");
		
		System.out.println("\t1 -- Quit");
		System.out.println("\t2 -- Insert");
		System.out.println("\t3 -- Remove");
		System.out.println("\t4 -- Print");
		System.out.println("\t5 -- Clear");
		
		System.out.print("Choice: ");
		
		return userInput.nextLine().charAt(0);
	}
	// Heart of the program. This method tackles what happens for each case the user selects from the menu.
	public static void menu(GeneralTree tree,Scanner userInput,ArrayList<Employee> addEmployees)
	{
		char choice = ' ';
		boolean isDone = false;
		String line;
		//This array list will hold the children of the root node being the managers.
		ArrayList<Node> managerArray;
		ArrayList<Node> workerArray;
		
		while (! isDone)
		{
			//This is the array of managers which are children nodes under the president root node.
			managerArray = tree.getRoot().getChildren();
			//if the array list which contains the managers is empty than I force the user to create a manager.
			if(managerArray.size() == 0)
			{
				//I'm forcing the user to create a manager before I get to the point later where they can add more managers or a worker under
				//a manager.
				System.out.println(); //Gives a space.
				System.out.println("A manager has to be entered before any workers.");
				System.out.println("*Create manager*\n");
				System.out.print("What is the id of this manager?");
				int manID = userInput.nextInt();
				userInput.nextLine();
				
				System.out.print("What is the name of this manager?");
				String name = userInput.nextLine();
				
				System.out.print("What is the location where this manager works?");
				String location = userInput.nextLine();
				//Creates a manager object.
				Employee firstManager = new Employee(manID,name,"Manager",location);
				//Adds the manager to my addEmployees array list used for checking duplicates.
				addEmployees.add(firstManager);
				//Insert the manager into the tree.
				tree.getRoot().insert(new Node(firstManager));
			}
				//Cycle through the children of the President being the managers. I will do the same for the workers later.
				for(Node manager: managerArray)
				{
					//If the managers value and title don't match up then throw error.
					if (!manager.getValue().getTitle().equals("Manager"))
					{
						System.out.println("Employee #" + manager.getValue().getId() + "Error has occurred.Reason being, a"
								+ "worker was attempted to be placed under the president and not under a manager. ");
					}
					//I'm creating an array list which stores the children of the managers being the workers.
					workerArray = manager.getChildren();
					
					//Cycle through the array of children of the managers.
					for(Node workers: workerArray)
					{  
						//If the worker's title doesn't match up then this isn't a worker and throw error.
						if(!workers.getValue().getTitle().equals("Worker"))
						{
							System.out.println("Employee #" + workers.getValue().getId() + "Only workers allowed on this level");
						}
						//If the worker's array list has children throw error as they shouldn't have children.
						if(workers.getChildren().size() != 0)
						{
							System.out.println("Workers shouldn't have anything below them.");
						}
					}
					
				}
				//choice from menu to create switch statement for menu options 1-5.
				choice = getChoice(userInput);
				
			//Switch statement for menu options 1-5.
			switch (choice)
			{
			// Quit
			case '1':			
				isDone = true;
				break;
			//Insert something into a node.
			case '2':				
				System.out.print("What would you like to enter: A. Manager B.Worker");
				String response = userInput.nextLine();
				switch(response)
				{
				case "A":
				case "Manager":
				case "a":
				case "manager":
					System.out.print("What is the ID number of the manager you wish to add?");
					int managerID = userInput.nextInt();
					userInput.nextLine();
					
					System.out.print("What is the name of this manager?");
					String name = userInput.nextLine();
					
					System.out.print("What is the location where this manager works?");
					String location = userInput.nextLine();
					//Creates a new manager object.
					Employee manager = new Employee(managerID,name,"Manager",location);
					//Now I'm taking use of my addEmployees array list for duplicates.
					//if the arraylist which contains all types of employes contains this manager attempted to be created.
					//That manager already exists.
					if(addEmployees.contains(manager))
					{
						System.out.println("That manager already exists.");
					}
					//Other wise I want to add this manager to the arraylist, and insert this manager into a node.
					else
					{
						addEmployees.add(manager);
						tree.getRoot().insert(new Node(manager));
					}
					//Break out of case A/manager.
					break;
					
				case "B":
				case "Worker":
				case "b":
				case "worker":
					System.out.print("What is the ID number of the manager you wish to add this worker under?");
					int existingManager = userInput.nextInt();
					userInput.nextLine();
					//index will be the valid position in the array which has the manager I'm looking for.
					int index = -1;
					int counter = 0;
					//Cycle through the children of the President being the managers.
					for(Node managers: managerArray)
					{
						//If the managers title and the ID match then I want to keep track of where in the array that valid manager is through
						//assigning my index variable to the counter.
						if(managers.getValue().getTitle().equals("Manager") && managers.getValue().getId() == existingManager)
						{
							//index becomes what the counter is at the point that the manager's ID matches with a manager in the array list.
							index = counter;
						}
						//counter keeps track of where I am in the array list.
						counter++;
					}
					//if the index hasn't been updated to the manager I want in the array list then throw error.
					if(index == -1)
					{
						System.out.println("That manager doesn't exist.");
					}
					//else creationg of worker.
					else
					{
						System.out.println("*Create worker*");
						System.out.print("Enter an ID number for this worker of the office.");
						int workerID = userInput.nextInt();
						userInput.nextLine();
						
						System.out.print("Enter the name for this worker of the office.");
						String workerName = userInput.nextLine();
						
						System.out.print("Enter where this worker is located at.");
						String workerLocation = userInput.nextLine();
						//Create worker object.
						Employee worker = new Employee(workerID,workerName,"Worker",workerLocation);
						//If this worker is a exsists throw error.
						if(addEmployees.contains(worker))
						{
							System.out.println("That employee already exists.");
						}
						//Other wise add this worker to the array list for cheking duplicates, and create this new node being a worker.
						//Also,insert into the tree this child at the index again being the position in the array list I want.
						else
						{
							addEmployees.add(worker);
							Node newNode = new Node(worker);
							tree.getRoot().getChild(index).insert(newNode);
						}
					}
					//break out of case B/worker.
					break;
					
					default:
						System.out.println("You did not enter option a or b.Please enter either a manager or a worker.");
				}
				break;
				
			//Remove employee from tree.
			case '3':				
				System.out.print("What would you like to enter: A. President B.Manager C.Worker");
				response = userInput.nextLine();
				
				System.out.print("What is the id of the employee you would like to remove?");
				int idToBeRemoved = userInput.nextInt();
				userInput.nextLine();
				//index variables whill be assigned to the count variables later after the for each loops to hold the item
				//in the array list I'm looking for aka manager/child.
				int index1 = -1;
				int index2 = -2;
				int count1 = 0;
				int count2 = 0;
				
				switch(response)
				{
				case "A":
				case "President":
				case "a":
				case "president":
					//When trying to remove the president, I want to clear the tree and set the new root.
					tree.clear();
					setNewRoot(tree,userInput,addEmployees);
					break;
				case "B":
				case "Manager":
				case "b":
				case "manager":
					
					managerArray = tree.getRoot().getChildren();
					//Cycle through the children of the President being the managers. 
					
					for(Node manager: managerArray)
					{
						//If the manager's id doesn't match the id attemped to be removed,then I want to keep track of this postiong
						// by index 1.
						if (manager.getValue().getId() == idToBeRemoved)
						{
							index1 = count1;
						}
						count1++;
					}
					if(index1 == -1)
					{
						System.out.println("That manager doesn't exist.");
					}
					else
					{
						//remove this child from the array list.
						tree.getRoot().getChildren().remove(index1);
					}
					
					break;
					
				case "C":
				case "Worker":
				case "c":
				case "worker":
					
					managerArray = tree.getRoot().getChildren();
					//Cycle through the managers.
					for(Node manager:managerArray)
					{
						//Create a copy of the managers.
						ArrayList<Node> copyCurManChildList = manager.getChildren();
						
						count2 = 0;
						//Cycle thourhg the workers being the children of the managers.
						for(Node worker : copyCurManChildList)
						{
							if(worker.getValue().getId() == idToBeRemoved)
							{
								//Assign index2 being the correct spot in the array list containing the worker I want.
								index2 = count2;
								//Assign index1 being the correct spot in the array list containing the manager I want.
								index1 = count1;
							}
							//count2 to contain the worker I want.
							count2++;
						}
						//count1 to contain the manager I want.
						count1++;
					}
					//If the indexes which control the spot in the array containing the thing I want haven't chanaged.Then
					//that means this worker doesn't exist.
					if(index1 == -1 && index2 == -2)
					{
						System.out.println("That worker doesn't exist.");
					}
					else
					{
						//gets the manager the worker is attached to and removes the worker.
						tree.getRoot().getChild(index1).remove(index2);
					}
					
					break;
					
				default:
					System.out.println("You didn't enter options a,b or c.Please enter a valid option.");
				}
				
				break;
			case '4':				// Print
				tree.print();
				break;
			case '5':				// Clear
				tree.clear();
				setNewRoot(tree,userInput,addEmployees);
				break;
			}
		}
		//Good practice to close out scanner avoiding memory leaks.
		userInput.close();
	}
	//Sets the new root of the tree.
	public static void setNewRoot(GeneralTree tree,Scanner userInput,ArrayList<Employee>addEmployees)
	{
				System.out.println("Before getting to our main menu please create a president and manager for the office.");
				System.out.println("*Create president*");
				
				System.out.print("Enter an ID number for the president of the office.");
				int ID = userInput.nextInt();
				userInput.nextLine();
				
				System.out.print("Enter the name for the president of the office.");
				String name = userInput.nextLine();
				
				System.out.print("Enter where this person is located at.");
				String location = userInput.nextLine();
				//Creates president object.
				Employee president = new Employee(ID,name,"President",location);
				//Adds the president to my arrayList for storing all employees.
				addEmployees.add(president);
				//Creates the president as the root node which has no first or sibling argument hence the null null.
				tree.newRoot(president, null, null);
				//Call for the menu which does the heart of the program. I pass it userInput and most of my methods the Scanner object
				//so I don't have to have scanners everywhere.
	}
}