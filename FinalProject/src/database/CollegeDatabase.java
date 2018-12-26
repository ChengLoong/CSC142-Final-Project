package database;

import people.*;
import java.io.File;
import java.util.Scanner;
/***********************************
 * Class:			CollegeDatabase()
 * 					defines a database that has a Person array and an index for the array
 * 					contains methods to add, remove, search, and modify the people in the database 
 ***********************************/
public class CollegeDatabase implements Database{

	private Person[] 		entry;
	private int 			size;
	public static final int DEFAULT_SIZE = 20;
	public static final int NOT_FOUND = -1;
	
	
	/***********************************
	 * Constructor:		CollegeDatabase()
	 * 					accepts the max size of an array and initializes size to 0
	 ***********************************/
	public CollegeDatabase(int capacity) throws IllegalArgumentException{
		if (capacity <=0) {
			throw new IllegalArgumentException("Capacity must be positive.");
		}
		size 	= 0;
		entry 	= new Person[capacity];
	}
	
	/***********************************
	 * Constructor:		CollegeDatabase()
	 * 					creates an array of default size and initializes size to 0
	 ***********************************/
	public CollegeDatabase() {
		this(DEFAULT_SIZE);
	}
	
	/***********************************
	 * Method:			add()
	 * 					adds a person to the database and increments size by 1
	 * 					increases the size of the database if it is full
	 * 					does not add a person if there is someone with the same name
	 ***********************************/
	public void add(Person person){
		if (findLocation(person.getName()) == NOT_FOUND) {
			entry[size] = person;
			size++;
			if (size >= entry.length) {
				expand();
			}
		}
		else {
			System.out.println("Person with this name already exists:" + person.getName());
		}
	}
	
	/***********************************
	 * Method:			ageFilter()
	 * 					returns true if the age of the person matches the criteria given
	 * 					otherwise returns false
	 ***********************************/
	public boolean ageFilter(Person person, int age, LessMore criteria) throws IllegalArgumentException {
		if (age <= 0) {
			throw new IllegalArgumentException("Age cannot be 0 or less");
		}
		else {
			if (criteria == LessMore.LESS) {
				if (person.getAge() < age) {
					return true;
				}
				return false;
			}
			else if (criteria == LessMore.MORE) {
				if (person.getAge() > age) {
					return true;
				}
				return false;
			}
		throw new IllegalArgumentException("Broken if/else branch");
		}
	}
	
	
		
	/***********************************
	 * Method:			delete()
	 * 					searches the database for a person by name
	 * 					if person is found, removes the person from the database and returns true
	 * 					if not found, prints message and returns false
	 ***********************************/
	public boolean delete(String name) {
		for (int i = 0; i < size; i++) {
			if (name.equals(entry[i].getName() ) ) {
				for (int j = i; j < size; j++) {
					entry[j] = entry[j + 1];
				}
				size--;
				return true;
			}
		}
		System.out.println("Person not found in Database");
		return false;
		
	}
	/***********************************
	 * Method:			expand()
	 * 					creates a new database of double the length of the old one
	 * 					copies the old entries into the new database
	 * 					returns the new database
	 ***********************************/
	private void expand() {
		int newLength = size * 2;
		Person[] newDatabase = new Person[newLength];
		for (int i = 0; i < size; i++) {
			newDatabase[i] = entry[i];
		}
		entry = newDatabase;
	}
	
	
	/***********************************
	 * Method:			findLocation()
	 * 					returns the index of the name in the database
	 * 					otherwise returns NOT_FOUND
	 ***********************************/
	private int findLocation(String name) {
		for (int i = 0; i < size; i++) {
			if (name.equals(entry[i].getName() ) ) {
				return i;
			}
		}
		return NOT_FOUND;
	}
	
	/***********************************
	 * Method:			get()
	 * 					returns person information at current index
	 ***********************************/
	public Person get(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("Array index must be greater than 0");
		}
		else if (index > size) {
			throw new ArrayIndexOutOfBoundsException("There aren't that many people in the database");
		}
		return entry[index];
	}
	
	/***********************************
	 * Method:			getDatabase()
	 * 					returns the current database
	 ***********************************/
	public Person[] getDatabase() {
		return entry;
	}
	
	/***********************************
	 * Method:			gpaOrSalaryFilter()
	 * 					returns true if the gpa or salary of the person matches the criteria given
	 * 					otherwise returns false
	 ***********************************/
	public boolean gpaOrSalaryFilter(Person person, double gpaSalaryValue, LessMore criteria) 
			throws IllegalArgumentException {
		if (person instanceof Student && criteria == LessMore.LESS) {
			if ( ( (Student)person).getGpa() < gpaSalaryValue) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (person instanceof Student && criteria == LessMore.MORE) {
			if ( ( (Student)person).getGpa() > gpaSalaryValue) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (person instanceof Employee && criteria == LessMore.LESS) {
			if ( ( (Employee)person).getSalary() < gpaSalaryValue) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (person instanceof Employee && criteria == LessMore.MORE) {
			if ( ( (Employee)person).getSalary() > gpaSalaryValue) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			throw new IllegalArgumentException("Broken if/else branch");
		}
	}
	
	/***********************************
	 * Method:			makeEmployeeDatabase()
	 * 					returns a copy of the database that contains only employees
	 ***********************************/
	public CollegeDatabase makeEmployeeDatabase() {
		CollegeDatabase newDatabase = new CollegeDatabase();
		int count = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.entry[i] instanceof Employee) {
				newDatabase.entry[count] = this.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	/***********************************
	 * Method:			makeEmployeeDatabaseAgeLessThan()
	 * 					returns a copy of the database that contains only employees 
	 * 					younger than the age given
	 ***********************************/
	public CollegeDatabase makeEmployeeDatabaseAgeLessThan(int age) {
		CollegeDatabase newDatabase = this.makeEmployeeDatabase();
		int count = 0;
		for (int i = 0; i < newDatabase.size(); i++) {
			if (newDatabase.ageFilter(newDatabase.entry[i], age, LessMore.LESS)) {
				newDatabase.entry[count] = newDatabase.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	/***********************************
	 * Method:			makeEmployeeDatabaseAgeMoreThan()
	 * 					returns a copy of the database that contains only employees 
	 * 					older than the age given
	 ***********************************/
	public CollegeDatabase makeEmployeeDatabaseAgeMoreThan(int age) {
		CollegeDatabase newDatabase = this.makeEmployeeDatabase();
		int count = 0;
		for (int i = 0; i < newDatabase.size(); i++) {
			if (newDatabase.ageFilter(newDatabase.entry[i], age, LessMore.MORE)) {
				newDatabase.entry[count] = newDatabase.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	/***********************************
	 * Method:			makeEmployeeDatabaseSalaryLessThan()
	 * 					returns a copy of the database that contains only employees
	 * 					who have a salary under the given value
	 ***********************************/
	public CollegeDatabase makeEmployeeDatabaseSalaryLessThan(double salary) {
		CollegeDatabase newDatabase = this.makeEmployeeDatabase();
		int count = 0;
		for (int i = 0; i < newDatabase.size(); i++) {
			if (newDatabase.gpaOrSalaryFilter(newDatabase.entry[i], salary, LessMore.LESS)) {
				newDatabase.entry[count] = newDatabase.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	/***********************************
	 * Method:			makeEmployeeDatabaseSalaryMoreThan()
	 * 					returns a copy of the database that contains only employees
	 * 					who have a salary over the given value
	 ***********************************/
	public CollegeDatabase makeEmployeeDatabaseSalaryMoreThan(double salary) {
		CollegeDatabase newDatabase = this.makeEmployeeDatabase();
		int count = 0;
		for (int i = 0; i < newDatabase.size(); i++) {
			if (newDatabase.gpaOrSalaryFilter(newDatabase.entry[i], salary, LessMore.MORE)) {
				newDatabase.entry[count] = newDatabase.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	
	/***********************************
	 * Method:			makeStudentDatabase()
	 * 					returns a copy of the database that contains only students
	 ***********************************/
	public CollegeDatabase makeStudentDatabase() {
		CollegeDatabase newDatabase = new CollegeDatabase();
		int count = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.entry[i] instanceof Student) {
				newDatabase.entry[count] = this.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	/***********************************
	 * Method:			makeStudentDatabaseAgeLessThan()
	 * 					returns a copy of the database that contains only students
	 * 					under the age given
	 ***********************************/
	public CollegeDatabase makeStudentDatabaseAgeLessThan(int age) {
		CollegeDatabase newDatabase = this.makeStudentDatabase();
		int count = 0;
		for (int i = 0; i < newDatabase.size(); i++) {
			if (newDatabase.ageFilter(newDatabase.entry[i], age, LessMore.LESS)) {
				newDatabase.entry[count] = newDatabase.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	/***********************************
	 * Method:			makeStudentDatabaseAgeMoreThan()
	 * 					returns a copy of the database that contains only students
	 * 					over the age given
	 ***********************************/
	public CollegeDatabase makeStudentDatabaseAgeMoreThan(int age) {
		CollegeDatabase newDatabase = this.makeStudentDatabase();
		int count = 0;
		for (int i = 0; i < newDatabase.size(); i++) {
			if (newDatabase.ageFilter(newDatabase.entry[i], age, LessMore.MORE)) {
				newDatabase.entry[count] = newDatabase.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	/***********************************
	 * Method:			makeStudentDatabaseGpaLessThan()
	 * 					returns a copy of the database that contains only student
	 * 					who have a GPA under the given value
	 ***********************************/
	public CollegeDatabase makeStudentDatabaseGpaLessThan(double GPA) {
		CollegeDatabase newDatabase = this.makeStudentDatabase();
		int count = 0;
		for (int i = 0; i < newDatabase.size(); i++) {
			if (newDatabase.gpaOrSalaryFilter(newDatabase.entry[i], GPA, LessMore.LESS)) {
				newDatabase.entry[count] = newDatabase.entry[i];
				count++;
			}
		}
		newDatabase.size = count;
		return newDatabase;
	}
	
	/***********************************
	 * Method:			makeStudentDatabaseGpaMoreThan()
	 * 					returns a copy of the database that contains only student
	 * 					who have a GPA over the given value
	 ***********************************/
	public CollegeDatabase makeStudentDatabaseGpaMoreThan(double GPA) {
		CollegeDatabase newDatabase = this.makeStudentDatabase();
		int count = 0;
		for (int i = 0; i < newDatabase.size(); i++) {
			if (newDatabase.gpaOrSalaryFilter(newDatabase.entry[i], GPA, LessMore.MORE)) {
				newDatabase.entry[count] = newDatabase.entry[i];
				count++;
			}
		}	
		newDatabase.size = count;
		return newDatabase;
	}
	
	
	/***********************************
	 * Method:			printSearch()
	 * 					returns a CollegeDatabase of the search results
	 * 					to be printed to a file
	 ***********************************/
	public CollegeDatabase printSearch(String name) {
		CollegeDatabase temp = new CollegeDatabase();
		temp.add(search(name));
		return temp;
	}
	
	/***********************************
	 * Method:			search()
	 * 					searches the database for the person by name
	 * 					returns the person if found
	 * 					prints message and returns null if not found
	 ***********************************/
	public Person search(String name) {
		if (findLocation(name) <= -1) {
			System.out.println("Person not in Database");
			return null;
		}
		return entry[findLocation(name)];
	}
	
	
	/***********************************
	 * Method:			size()
	 * 					returns the number of people in the database
	 ***********************************/
	public int size() {
		return size;
	}
	
	/***********************************
	 * Method:			toString()
	 * 					returns a person's information in string format
	 ***********************************/
	public String toString() {
		String tempString = "";
		for (int i =0; i < size; i++) {
			tempString += "\n" + entry[i].toFile();
		}
		return tempString;
	}


}
