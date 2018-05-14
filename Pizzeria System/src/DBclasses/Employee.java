package DBclasses;

public class Employee {
	private int num;
	private long ID;
	private String firstName;
	private String lastName;
	private double workHours  = 0;
	private boolean worksNow = false;
	private static int numEmployees = 0;
	public Employee(long ID,String firstName,String lastName){
		numEmployees++;
		num = numEmployees;
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void working(){
		if (worksNow) worksNow = false;
		else worksNow = true;
		}
	public String toString(){
		return firstName+" "+lastName;
	}
}
