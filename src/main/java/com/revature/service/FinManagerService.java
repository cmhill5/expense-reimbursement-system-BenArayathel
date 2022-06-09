package com.revature.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.FinManagerDao;
import com.revature.dao.FinManagerDaoImpl;
import com.revature.dao.LogDao;
import com.revature.dao.LogDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.models.FinManager;
import com.revature.models.Log;
import com.revature.models.Request;

public class FinManagerService {

	private static FinManagerDao finDao = new FinManagerDaoImpl();
	private static RequestDao reqDao = new RequestDaoImpl();
	private static LogDao lDao = new LogDaoImpl();
	
	public static boolean finmanagerLogin(String user, String pass) {
		boolean result = false;
		FinManager fin = finDao.selectFinManagerByName(user);
		
		if(fin == null) {
			System.out.println("ERROR: No Financial Manager by this Username");
		}
		else if(SystemService.authenticateFin(fin, pass)) {
			result = true;
		}

		return result;
	}
	
	public static FinManager getFinManagerById(int id) {
		FinManager fin = finDao.selectFinManagerById(id);
		
		return fin;
	}
	
	public static FinManager getFinManagerByUsername(String user) {
		FinManager fin = finDao.selectFinManagerByName(user);
		
		return fin;
	}
	
	public static List<FinManager> getAllFinManagers(){
		List<FinManager> finList = finDao.selectAllFinManagers();
		
		return finList;
	}
	
	public static List<Request> getRequestQueue(){
		List<Request> requestList = reqDao.selectAllRequests();
		
		return requestList;
	}
	
	public static List<Log> getLogsByAcceptance(boolean isAccepted){
		List<Log> logsList = lDao.selectAllLogsByAcceptance(isAccepted);
		
		return logsList;
	}
	
	public static List<Log> getLogs(){
		List<Log> logsList = lDao.selectAllLogs();
		
		return logsList;
	}

	@Transactional
	public static boolean fromRequestToLog(FinManager fin, int req_id, boolean isAccepted) {
		
		try {
			Request req = reqDao.selectRequestById(req_id);
			Log l = new Log(isAccepted, req.getCategory(), req.getBalance(), req.getMy_emp_id(), fin.getId());
			
			lDao.insertLog(l);
			reqDao.deleteRequest(req);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
