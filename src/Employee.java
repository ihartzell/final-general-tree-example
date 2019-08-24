
public class Employee 
{
	private int employeeId;
	private String name;
	private String title;
	private String location;
	
	public Employee (int id, String name, String title, String location)
	{
		this.employeeId = id;
		this.name = name;
		this.title = title;
		this.location = location;
	}
	
	public int getId()
	{
		return employeeId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setId(int id)
	{
		this.employeeId = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public String toString()
	{
		return Integer.toString(employeeId) + name + ", " + title + ", " + location;
	}
}
