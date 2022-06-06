package com.revature.dao;

import java.util.List;

import com.revature.models.Request;
import com.revature.models.Employee;

public interface RequestDao {

	public void insertRequest(Request req);
	
	public Request selectRequestById(int id);
	public Request selectOldestRequest();
	public List<Request> selectRequestsByEmployeeId(Employee emp);
	public List<Request> selectAllRequests();

	public void deleteRequest(Request req);
}
