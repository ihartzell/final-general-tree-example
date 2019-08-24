package Using_ArrayList;

import java.util.ArrayList;

public class GeneralTree 
{
	//root is the root Node.
	private Node root;
	private int size;
	
	public GeneralTree()
	{
		root = null;
		size = 0;
	}
	//Makes the root null and assigns the size to the size of the children array list
	//which effectively clears the tree.
	public void clear()
	{
		root = null;
		size = 0;
	}
	//Gets the root node.
	public Node getRoot()
	{
		return root;
	}
	
	//Creates the a new root node being whatever employee argument is passed in such as president.
	public void newRoot(Employee value, Node first, Node sib)
	{
		root = new Node (value);
	}
	//Adds a child to the tree being the employee passed in.
	public void newLeftChild(Employee value)
	{
		root.getChildren().add(new Node(value));
	}
	// Recursively does a preOrder print for levels 0-2 for the president,manager,and employee/worker information.
	private void preOrder(Node subRoot, int level)
	{
		//switch statment for levels 0-2
		switch (level)
		{
		//President's data print.
		case 0:
			System.out.println("President: " + subRoot.getValue().toString());
			break;
		//Manager's data print.
		case 1:
			System.out.println("\tManager: " + subRoot.getValue().toString());
			break;
		//Worker's data print.
		case 2:
			System.out.println("\t\tWorker: " + subRoot.getValue().toString());
			break;
		default:
			for (int i = 0; i < level; i++)
				System.out.print("\t");
			System.out.println(subRoot.getValue().toString());
		}
		
		for (int i = 0; i < subRoot.length(); i++)
			preOrder(subRoot.getChild(i),level +1);
	}
	//Calls for recursive preOrder.
	public void preOrder()
	{
		preOrder(root, 0);
	}
	//Calls for preOrder which effectively does the printing.
	public void print()
	{
		preOrder(root,0);
	}
}
