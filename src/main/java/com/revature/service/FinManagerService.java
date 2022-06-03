package com.revature.service;

import com.revature.dao.FinManagerDao;
import com.revature.dao.FinManagerDaoImpl;
import com.revature.dao.LogDao;
import com.revature.dao.LogDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.models.Employee;
import com.revature.models.FinManager;

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
	
	
}
