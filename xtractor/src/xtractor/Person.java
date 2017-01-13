package xtractor;

import org.neo4j.ogm.annotation.*;

@NodeEntity
public class Person {
	
	
	@GraphId
	private Long graphId;
	
	
	private String firstName;
	
	private String lastName;
	
	
	
	
	private int birthdate;
	
	private String birthplace;
	
	public Person(){
		
	}
	public Person(String firstName){
		this.firstName = firstName;
		System.out.println("Person created");
	}
	
	
	
	//get and set methods
	
	public void setfirstName(String firstName){
		this.firstName = firstName;
	}
	public String getfirstName(){
		return this.firstName;
	}
	
	
	public void setlastName(String lastName){
		this.lastName = lastName;
	}
	public String getlastName(){
		return this.lastName;
	}
	
	
	public void setBirthdate(int date){
		this.birthdate = date;
	}
	
	public int getBirthdate(){
		return this.birthdate;
	}
	
	
	public void setBirthplace(String place){
		this.birthplace = place;
	}
	
	public String getBirthplace(){
		return this.birthplace;
	}

	
}
