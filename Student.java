//immutable class is not modifiable class with keyword key
public final class Student 
{ 
	final String name; 
	final int id; 
  
	public Student(String name, int id) 
	{ 
		this.name = name; 
		this.id = id; 
	} 
	public String getName() 
	{ 
		return name; 
	} 
	public int getId() 
	{ 
		return id; 
	} 
} 
  
// Driver class 
class Test 
{ 
	public static void main(String args[]) 
	{ 
		Student s = new Student("ABC", 101); 
		System.out.println(s.getName()); 
		System.out.println(s.getId()); 
  
		// Uncommenting below line causes error 
		// s.regNo = 102; 
	} 
} 