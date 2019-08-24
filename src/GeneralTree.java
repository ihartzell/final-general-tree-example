public class GeneralTree 
{
	private Node root;
	private int size;
	
	public GeneralTree()
	{
		root = null;
		size = 0;
	}
	
	public void clear()
	{
		root = null;
		size = 0;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public void newRoot(Employee value, Node first, Node sib)
	{
		Node subNodes[];
		
		if (first != null && sib != null) // has a siblings
		{
			subNodes = new Node[2];
			subNodes[0] = first;
			subNodes[1] = sib;
		}
		else if (first != null)
		{
			subNodes = new Node[1];
			subNodes[0] = first;
		}
		else if (sib != null)
		{
			subNodes = new Node[1];
			subNodes[0] = sib;
		}
		else 
		{
			subNodes = new Node[0];
		}
		
		clear();
		
		root = new Node(value,null,subNodes);
		
		if (first != null)
		{
			first.setParent(root);
		}
		
		if (sib != null)
		{
			sib.setParent(root);
		}
	}
	
	public void newLeftChild(Employee value)
	{
		if (root == null)
		{
			root = new Node(value);
			return;
		}
		
		Node subNodes[] = new Node[0];
		
		Node temp = new Node(value,root,subNodes);
		root.insertFirst(temp);
	}
	
	private void preOrder(Node subRoot, int level)
	{
		switch (level)
		{
		case 0:
			System.out.println("President: " + subRoot.getValue().toString());
			break;
		case 1:
			System.out.println("\tManager: " + subRoot.getValue().toString());
			break;
		case 2:
			System.out.println("\t\tEmployee: " + subRoot.getValue().toString());
			break;
		default:
			for (int i = 0; i < level; i++)
				System.out.print("\t");
			System.out.println(subRoot.getValue().toString());
		}
		
		for (int i = 0; i < subRoot.length(); i++)
			preOrder(subRoot.getChild(i),level +1);
	}
	
	public void preOrder()
	{
		preOrder(root, 0);
	}
	
	public void print()
	{
		preOrder(root,0);
	}
}

