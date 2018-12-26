package database;
/* reads information from a file and puts it into an database
 * or writes information from an database into a file
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import people.*;
/***********************************
 * Class:			DatabaseStorage()
 * 					contains methods to read and write information to a file
 ***********************************/
public class DatabaseStorage{

	private File file;
	
	/***********************************
	 * Method:			DatabaseStorage()
	 * 					set the file path for the database to read from or write to
	 * @throws IOException 
	 ***********************************/
	public DatabaseStorage(String filePath) throws NullPointerException, IOException{
		setFile(filePath);
	}
	
	/***********************************
	 * Method:			DatabaseStorage()
	 * 					tells the user when an invalid file path is given
	 ***********************************/
	public DatabaseStorage() throws IOException{
		throw new IOException("Error: no file path given");
	}
	
	/***********************************
	 * Method:			parsePerson()
	 * 					returns an employee or a student object
	 * 					using information passed to it
	 ***********************************/
	public static Person parsePerson (String line) throws IllegalArgumentException{
		
		String[] 	info 		= line.split(",");
		if (info.length < 5) {
			throw new IllegalArgumentException("String does not contain enough information");
		}
		
		Person 		anyPerson	= null;
		
		String 		name 		= info[1];
		int 		age 		= Integer.parseInt(info[2]);
		Person		person		= new Person(name, age);
		
		if (info[0].equals("Student")) {
			Status status 	= Status.valueOf(info[3]);
			double gpa 		= Double.parseDouble(info[4]);
			anyPerson 		= new Student(person, status, gpa);
			
		}
		else if (info[0].equals("Employee")) {
			String office	= info[3];
			Double salary	= Double.parseDouble(info[4]);
			anyPerson		= new Employee(person, office, salary);
		}
	
		return anyPerson;
	}
	
	/***********************************
	 * Method:			read()
	 * 					reads data from a file and puts it into a database
	 * 					uses parsePerson() to create database entries
	 ***********************************/
	public CollegeDatabase read() throws IOException { 
		if (file.exists()) {
			CollegeDatabase database = new CollegeDatabase(20);

			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				database.add(parsePerson(line));
			}
			input.close();
			return database;
		}
		else {
			throw new IOException("File not found");
		}
	}
	
	/***********************************
	 * Method:			setFile()
	 * 					sets the file path
	 ***********************************/
	public void setFile(String filePath) {
		file = new File(filePath);
		
	}
	
	/***********************************
	 * Method:			writeCommaSeparated()
	 * 					writes the current database to a file in comma separated format
	 ***********************************/
	public void writeCommaSeparated(CollegeDatabase database) throws IOException {
		if (file.exists()) {
			throw new IOException("File already exists and data may be erased");
		}
		PrintWriter output = new PrintWriter(file);
		for (int i = 0; i < database.size(); i++) {
			output.println(database.get(i).toFile() );
		}
		output.close();
	}
	
	/***********************************
	 * Method:			writeString()
	 * 					writes the current database to a file in easy to read format
	 ***********************************/
	public void write(CollegeDatabase database) throws IOException {
		if (file.exists()) {
			throw new IOException("File already exists and data may be erased");
		}
		PrintWriter output = new PrintWriter(file);
		for (int i = 0; i < database.size(); i++) {
			output.println(database.get(i).toString() );
		}
		output.close();
	}

}
