package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import people.*;
import database.*;

public class DataTestClient{

	static String fileReadLocation = 	File.separator + "F:" +
										File.separator + "Fall 2018" +
										File.separator + "CSC142" +
										File.separator + "College.txt";

	static String fileWriteLocation = 	File.separator + "F:" +
										File.separator + "Fall 2018" +
										File.separator + "CSC142" +
										File.separator + "Test.txt";
	/***********************************
	 * Method:		main()
	 * 				runs the program
	 ***********************************/
	public static void main(String[] args) throws IOException {

		DatabaseStorage storage = new DatabaseStorage(fileReadLocation);
//		
		CollegeDatabase test = storage.read();
		storage.setFile(fileWriteLocation);
		
		/***********************************
		 * Preliminary Testing:		testing for ability to read/write to file and miscellaneous errors
		 ***********************************/
//		DatabaseStorage storage = new DatabaseStorage();
				
		storage.write(test);
//		storage.writeCommaSeparated(test);
		
//		Person[] person = test.getDatabase();
//		System.out.println(person[0].toString());
		
//		storage.write(test.printSearch("Virginia Alcott"));
//		
		/***********************************
		 * Separation:		testing the separation criteria
		 ***********************************/
//		CollegeDatabase studentDatabase = test.makeStudentDatabase();
//		System.out.println(studentDatabase.toString());
//		CollegeDatabase employeeDatabase = test.makeEmployeeDatabase();
//		System.out.println(employeeDatabase.toString());
		
//		CollegeDatabase studentDatabaseGPAFiltered = test.makeStudentDatabaseGpaLessThan(2.0);
//		System.out.println(studentDatabaseGPAFiltered.toString());
//		CollegeDatabase studentDatabaseGPAFiltered = test.makeStudentDatabaseGpaMoreThan(3.0);
//		System.out.println(studentDatabaseGPAFiltered.toString());

//		CollegeDatabase employeeDatabaseSalaryFiltered = test.makeEmployeeDatabaseSalaryLessThan(55000.0);
//		System.out.println(employeeDatabaseSalaryFiltered.toString());
//		CollegeDatabase employeeDatabaseSalaryFiltered = test.makeEmployeeDatabaseSalaryMoreThan(55000.0);
//		System.out.println(employeeDatabaseSalaryFiltered.toString());

//		CollegeDatabase employeeDatabaseAgeFiltered = test.makeEmployeeDatabaseAgeMoreThan(40);
//		System.out.println(employeeDatabaseAgeFiltered.toString());
//		CollegeDatabase studentDatabaseAgeFiltered = test.makeStudentDatabaseAgeLessThan(25);
//		System.out.println(studentDatabaseAgeFiltered.toString());
		
		/***********************************
		 * Testing:		shows that each method in CollegeDatabase and DatabaseStorage work correctly
		 ***********************************/
//		System.out.println(test.get(0));
//		System.out.println(test.get(-1));
//		System.out.println(test.get(400));
		
//		Person testSubject = new Person("Adam Smith", 5);
//		test.add(testSubject);
//		System.out.println(test.toString());

//		System.out.println(test.search("Virginia Alcott") );
//		System.out.println(test.search("Jensen Candle") );
//		System.out.println(test.search("Wilbur Grant") );
		
//		System.out.println(test.search("Person not in database") );
		
//		test.delete("Virginia Alcott");
//		System.out.println(test.toString());
//		test.delete("Jensen Candle");
//		System.out.println(test.toString());
//		test.delete("Wilbur Grant");
//		System.out.println(test.toString());
//		test.delete("Not in database");
//		System.out.println(test.toString());
		
		

	}
	

}
