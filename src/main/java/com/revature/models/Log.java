package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Log {

	private int id;
	private Timestamp ts;
	private boolean isAccepted;
	private String category;
	private double balance;	
	private int empId;
	private int finId;
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Log(boolean isAccepted, String category, double balance, int empId, int finId) {
		this(0,new Timestamp(System.currentTimeMillis()),isAccepted,category,balance,empId,finId);
	}
	public Log(int id, Timestamp ts, boolean isAccepted, String category, double balance, int empId, int finId) {
		super();
		this.id = id;
		this.ts = ts;
		this.isAccepted = isAccepted;
		this.category = category;
		this.balance = balance;
		this.empId = empId;
		this.finId = finId;
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
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
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
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getFinId() {
		return finId;
	}
	public void setFinId(int finId) {
		this.finId = finId;
	}
	@Override
	public String toString() {
		return "\nLog [id=" + id + ", ts=" + ts + ", isAccepted=" + isAccepted + ", category=" + category + ", balance="
				+ balance + ", empId=" + empId + ", finId=" + finId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(balance, category, empId, finId, id, isAccepted, ts);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(category, other.category) && empId == other.empId && finId == other.finId
				&& id == other.id && isAccepted == other.isAccepted && Objects.equals(ts, other.ts);
	}
	
}
