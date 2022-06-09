package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.FinManager;
import com.revature.models.Log;

public interface LogDao {

public void insertLog(Log log);
	
	public Log selectLogById(int id);
	public List<Log> selectLogsByEmployeeId(Employee emp);
	public List<Log> selectLogsByFinManagerId(FinManager fin);
	public List<Log> selectAllLogsByAcceptance(boolean isAccepted);
	public List<Log> selectAllLogs();
}
