package com.revature.models;

import java.util.List;
import java.util.Objects;

public class Employee {

	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private List<Request> myRequests;
	private List<Log> myLogs;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String username, String password, String firstName, String lastName,
			List<Request> myRequests, List<Log> myLogs) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.myRequests = myRequests;
		this.myLogs = myLogs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Request> getMyRequests() {
		return myRequests;
	}
	public void setMyRequests(List<Request> myRequests) {
		this.myRequests = myRequests;
	}
	public List<Log> getMyLogs() {
		return myLogs;
	}
	public void setMyLogs(List<Log> myLogs) {
		this.myLogs = myLogs;
	}
	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", myRequests=" + myRequests + ", myLogs=" + myLogs + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, myLogs, myRequests, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(myLogs, other.myLogs) && Objects.equals(myRequests, other.myRequests)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
}
