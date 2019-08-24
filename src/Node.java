public class Node 
{
	private Employee element;
	private Node parent;
	private Node children[];
	int size;
	int maxSize;
	int currentChild;
	
	public Node()
	{
		size = maxSize = currentChild = 0;
		element = null;
		parent = null;
		children = null;
	}
	
	public Node(Employee it)
	{
		element = it;
		size = maxSize = currentChild = 0;
		parent = null;
		children = null;
	}
	
	public Node(Employee it, Node parent, Node children[])
	{
		element = it;
		size = maxSize = children.length;
		this.parent = parent;
		this.children = new Node [maxSize];
		for (int i = 0; i < maxSize; i++)
			this.children[i] = children[i];
	}
	
	public Employee getValue()
	{
		return element;
	}
	
	public void setValue(Employee it)
	{
		element = it;
	}
	
	public boolean isLeaf()
	{
		return size == 0;
	}
	
	public Node getParent()
	{
		return parent;
	}
	
	public void setParent(Node it)
	{
		parent = it;
	}
	
	public Node getLeftMostChild()
	{
		currentChild = 0;
		return children[currentChild];
	}
	
	public void insertFirst(Node it)
	{
		if (maxSize == size)
		{
			maxSize = maxSize * 2;
			if (maxSize == 0)
				maxSize = 10;
			
			Node temp[] = new Node[maxSize];
			for (int i = 0; i < size; i++)
				temp[i] = children[i];
			
			children = temp;
		}
		
		size++;
		
		for (int i = size; i > 0; i--)
			children[i] = children[i-1];
		
		children[0] = it;
		children[0].setParent(this);
	}
	
	public Node getRightSibling()
	{
		if (currentChild < size)
		{
			currentChild++;
			return children[currentChild];
		}
		else
			return null;
	}
	
	public void insertNext(Node it)
	{
		if (maxSize == size)
		{
			maxSize = maxSize * 2;
			if (maxSize == 0)
				maxSize = 10;
			
			Node temp[] = new Node[maxSize];
			for (int i = 0; i < size; i++)
				temp[i] = children[i];
			
			children = temp;
		}
		
		Node n = it;
		
		children[size] = n;
		children[size].setParent(this);
		
		size ++;

	}
	
	public int length() 
	{
		return size;
	}
	
	public Node getChild(int child)
	{
		return children[child];
	}

	public void removeFirst()
	{
		if (isLeaf())
			return;
		
		size--;
		
		for (int i = 0; i < size; i++)
			children[i] = children[i+1];
		
		children[size] = null;
	}
	
	public void removeNext()
	{
		if (isLeaf())
			return;
		
		size --;
		
		children[size] = null;
	}
	
	public void dump()
	{
		System.out.print("Value: ");
		System.out.println(element.toString());
		System.out.print("\tSize: ");
		System.out.println(size);
		System.out.print("\tMax Size: ");
		System.out.println(maxSize);
		
	}
	public Node[] getChildren()
	{
		return children;
	}
	
}
