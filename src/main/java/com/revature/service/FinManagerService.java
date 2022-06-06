package com.revature.service;

import java.util.List;

import com.revature.dao.FinManagerDao;
import com.revature.dao.FinManagerDaoImpl;
import com.revature.dao.LogDao;
import com.revature.dao.LogDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.models.Employee;
import com.revature.models.FinManager;
import com.revature.models.Log;
import com.revature.models.Request;

public class FinManagerService {

	private static FinManagerDao finDao = new FinManagerDaoImpl();
	private static RequestDao reqDao = new RequestDaoImpl();
	private static LogDao lDao = new LogDaoImpl();
	private static SystemService sysServ = new SystemServiceImpl();
	
	public boolean finmanagerLogin(String user, String pass) {
		boolean result = false;
		FinManager fin = finDao.selectFinManagerByName(user);
		
		if(fin == null) {
			System.out.println("ERROR: No Financial Manager by this Username");
		}
		else if(sysServ.authenticateFin(fin, pass)) {
			result = true;
		}

		return result;
	}
	
	public FinManager getFinManager(int id) {
		FinManager fin = finDao.selectFinManagerById(id);
		
		return fin;
	}
	
	public FinManager getFinManager(String user) {
		FinManager fin = finDao.selectFinManagerByName(user);
		
		return fin;
	}
	
	public List<Request> getRequestQueue(){
		List<Request> requestList = reqDao.selectAllRequests();
		
		return requestList;
	}
	
	public List<Log> getLogs(){
		List<Log> logsList = lDao.selectAllLogs();
		
		return logsList;
	}
	
	public void fromRequestToLog(int fin_id, int req_id, boolean isAccepted) {
		
		try {
			Request req = reqDao.selectRequestById(req_id);
			Log l = new Log(isAccepted, req.getCategory(), req.getBalance(), req.getMy_emp_id(), fin_id);
			
			lDao.insertLog(l);
			reqDao.deleteRequest(req);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fromRequestToLog(String finName, int req_id, boolean isAccepted) {
		
		try {
			Request req = reqDao.selectRequestById(req_id);
			FinManager fin = finDao.selectFinManagerByName(finName);
			Log l = new Log(isAccepted, req.getCategory(), req.getBalance(), req.getMy_emp_id(), fin.getId());
			
			lDao.insertLog(l);
			reqDao.deleteRequest(req);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
