package people;

public class Person {
	private String name;
	private int age;
	
	/************************************
	 * Constructor: Person()
	 * 				prints an error message when no parameters are passed
	 * **********************************/
	public Person() {
		System.out.println("Error: no arguments passed");
	}	
	
	/************************************
	 * Constructor: Person()
	 * 				Constructs a new Person with name and age fields
	 * **********************************/
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/************************************
	 * Constructor: Person()
	 * 				constructs a new person with name and age fields
	 * **********************************/
	public Person(String name) {
		this.name = name;
		this.age = 0;
	}	
	
	/************************************
	 * Accessor:	getAge()
	 * 				Returns age
	 * **********************************/
	public int getAge() {
		return age;
	}
	
	/************************************
	 * Accessor:	getName()
	 * 				Returns name
	 * **********************************/
	public String getName() {
		return name;
	}
	
	/************************************
	 * Method:		printStatus()
	 * 				Prints the object status
	 * **********************************/
	public void printStatus() {
		System.out.println("This is a College person");
	}
	
	/************************************
	 * Method:		profile()
	 * 				Prints the object profile
	 * **********************************/
	public String profile() {
		return ("Name:\t" + name + "\nAge:\t" + age);
	}
	
	/************************************
	 * Mutator:		setAge()
	 * 				modifies the field age
	 * **********************************/
	public void setAge(int age) {
		this.age = age;
	}
	
	/************************************
	 * Mutator:		setName()
	 * 				modifies the field name
	 * **********************************/
	public void setName(String name) {
		this.name = name;
	}

	/************************************
	 * Method:		toFile()
	 * 				Returns a string with information in comma separated format
	 * **********************************/
	public String toFile() {
		return name + "," + age;
	}

	/************************************
	 * Method:		toString()
	 * 				Returns a string with all the fields
	 * **********************************/
	public String toString() {
		return ("Name: " + name + "                 ").substring(0,30) + "Age: " + age;

//		return "Name: \t" + name 	+ "\t\t" +
//			   "Age: \t" 	+ age 	+ "\t";
		
	}
	
	public String rpad(String name, int finalLength) {
	    return (name + "                                         " // typically a sufficient length spaces string.
	        ).substring(0, finalLength);
	}
	
	
	
	
}
