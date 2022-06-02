package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Request {

	private int id;
	private Timestamp ts;
	private String category;
	private double balance;
	private int my_emp_id;
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(String category, double balance, int my_emp_id) {
		this(0,new Timestamp(System.currentTimeMillis()),category,balance,my_emp_id);
	}
	public Request(int id, Timestamp ts, String category, double balance, int my_emp_id) {
		super();
		this.id = id;
		this.ts = ts;
		this.category = category;
		this.balance = balance;
		this.my_emp_id = my_emp_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getMy_emp_id() {
		return my_emp_id;
	}
	public void setMy_emp_id(int my_emp_id) {
		this.my_emp_id = my_emp_id;
	}
	@Override
	public String toString() {
		return "\nRequest [id=" + id + ", ts=" + ts + ", category=" + category + ", balance=" + String.format("%.2f", balance) + ", my_emp_id="
				+ my_emp_id + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(balance, category, id, my_emp_id, ts);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(category, other.category) && id == other.id && my_emp_id == other.my_emp_id
				&& Objects.equals(ts, other.ts);
	}
	
	
}
