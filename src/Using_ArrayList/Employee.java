package Using_ArrayList;

//This class sets the blue print for an Employee being president,manager,worker.
public class Employee 
{
	//Data field variables.
	private int employeeId;
	private String name;
	private String title;
	private String location;
	
	//Constructor for creating my Employee object.
	public Employee (int id, String name, String title, String location)
	{
		this.employeeId = id;
		this.name = name;
		this.title = title;
		this.location = location;
	}
	//Gets the employee's ID number.
	public int getId()
	{
		return employeeId;
	}
	//Gets the employee's name.
	public String getName()
	{
		return name;
	}
	//Gets the employee's title.
	public String getTitle()
	{
		return title;
	}
	//Gets the employee's location.
	public String getLocation()
	{
		return location;
	}
	//Sets the employee's ID number.
	public void setId(int id)
	{
		this.employeeId = id;
	}
	//Sets the employee's name.
	public void setName(String name)
	{
		this.name = name;
	}
	//Sets the employee's title.
	public void setTitle(String title)
	{
		this.title = title;
	}
	//Sets the employee's location.
	public void setLocation(String location)
	{
		this.location = location;
	}
	//Prints the information for the employee.
	public String toString()
	{
		return Integer.toString(employeeId) + ", " + name + ", " + title + ", " + location;
	}
}

