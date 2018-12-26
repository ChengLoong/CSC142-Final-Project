package database;

import people.Person;

public interface Database {
	public void add(Person person);
	public boolean delete(String name);
	public Person search(String name);
	
}
