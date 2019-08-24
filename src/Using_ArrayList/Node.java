package Using_ArrayList;

import java.util.ArrayList;
//Makes the blue print for a node which is just a container for information on a stree structure.
public class Node 
{
	//element is the variable which will store the employee passed in such as a manager into the constructor.
	private Employee element;
	private Node parent;
	//ArrayList of children rather than an array of children as it makes this program infinitely more concise.
	private ArrayList<Node> children = new ArrayList<Node>();
	//size of the array.
	int size;
	//current child being a manager or worker.
	int currentChild;
	
	public Node()
	{
		size = children.size();
		element = null;
		parent = null;
		children = null;
	}
	
	public Node(Employee it)
	{
		element = it;
		size = children.size();
		parent = null;
		children = new ArrayList<Node>();
	}
	
	public Node(Employee it, Node parent, ArrayList<Node>children)
	{
		element = it;
		size = children.size();
		this.parent = parent;
		this.children.addAll(children);
	}
	//Gets the value being an employee.
	public Employee getValue()
	{
		return element;
	}
	//Sets the value being an employee.
	public void setValue(Employee it)
	{
		element = it;
	}
	//Returns a size of zero as the leaf has no children.
	public boolean isLeaf()
	{
		return size == 0;
	}
	//Gets the parent node.
	public Node getParent()
	{
		return parent;
	}
	//Sets the parent node.
	public void setParent(Node it)
	{
		parent = it;
	}
	//Gets the first child in the array list.
	public Node getLeftMostChild()
	{
		
		return this.children.get(0);
	}
	//Inserts something into a node.
	public void insert(Node it)
	{
		this.children.add(it);
		//Update size to what the arraylist's size is each time insert is called.
		size = children.size();
	}
	//Returns the size of the array list.
	public int length() 
	{
		size = children.size();
		return size;
	}
	//Get a child from the array list of children.
	public Node getChild(int child)
	{
		//As long as the size doesn't equal zero
		//return the Node with the child passed in for the array list.
		if(size != 0)
			return children.get(child);
		
		 return null;
	}
	//Remove an element from the array list passed in.
	public void remove(int i)
	{
		children.remove(i);
		size = children.size();
	}
	// Not using.
	public void dump()
	{
		System.out.print("Value: ");
		System.out.println(element.toString());
		System.out.print("\tSize: ");
		System.out.println(size);
		
	}
	//Gets the children array list.
	public ArrayList<Node> getChildren()
	{
		return children;
	}

}

