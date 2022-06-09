package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.FinManager;
import com.revature.models.Log;
import com.revature.util.ConnectionFactory;

public class LogDaoImpl implements LogDao {

	final String ID = "log_id";
	final String LOGTIME = "logtime";
	final String ISACCEPTED = "isaccepted";
	final String CATEGORY = "category";
	final String BALANCE = "balance";
	final String EMP_ID = "emp_id";
	final String FIN_ID = "fin_id";
	
	@Override
	public void insertLog(Log log) {
		String sql = "INSERT INTO logs (logtime,isaccepted,category,balance,emp_id,fin_id) VALUES (?,?,?,?,?,?)";
		Connection connection = ConnectionFactory.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setTimestamp(1, log.getTs());
			ps.setBoolean(2, log.isAccepted());
			ps.setString(3, log.getCategory());
			ps.setInt(4, (int)(log.getBalance()*100));
			ps.setInt(5, log.getEmpId());
			ps.setInt(6, log.getFinId());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Log selectLogById(int id) {
		String sql = "SELECT * FROM logs WHERE log_id = ?";
		Connection connection = ConnectionFactory.getConnection();
		
		Log log = new Log();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			log = new Log(
					rs.getInt(ID),
					rs.getTimestamp(LOGTIME),
					rs.getBoolean(ISACCEPTED),
					rs.getString(CATEGORY).trim(),
					rs.getInt(BALANCE)*0.01,
					rs.getInt(EMP_ID),
					rs.getInt(FIN_ID)
					);
			
		} catch (Exception e) {
			e.printStackTrace();
			log = null;
		}
		
		return log;
	}

	@Override
	public List<Log> selectLogsByEmployeeId(Employee emp) {
		String sql = "SELECT * FROM logs WHERE emp_id = ?";
		Connection connection = ConnectionFactory.getConnection();

		List<Log> logList = new ArrayList<>();
		Log log = new Log();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, emp.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				log = new Log(
						rs.getInt(ID),
						rs.getTimestamp(LOGTIME),
						rs.getBoolean(ISACCEPTED),
						rs.getString(CATEGORY).trim(),
						rs.getInt(BALANCE)*0.01,
						rs.getInt(EMP_ID),
						rs.getInt(FIN_ID)
						);
				
				logList.add(log);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logList = null;
		}
		
		return logList;
	}

	@Override
	public List<Log> selectLogsByFinManagerId(FinManager fin) {
		String sql = "SELECT * FROM logs WHERE fin_id = ?";
		Connection connection = ConnectionFactory.getConnection();

		List<Log> logList = new ArrayList<>();
		Log log = new Log();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, fin.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				log = new Log(
						rs.getInt(ID),
						rs.getTimestamp(LOGTIME),
						rs.getBoolean(ISACCEPTED),
						rs.getString(CATEGORY).trim(),
						rs.getInt(BALANCE)*0.01,
						rs.getInt(EMP_ID),
						rs.getInt(FIN_ID)
						);
				
				logList.add(log);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logList = null;
		}
		
		return logList;
	}

	@Override
	public List<Log> selectAllLogsByAcceptance(boolean isAccepted) {
		String sql = "SELECT * FROM logs";
		Connection connection = ConnectionFactory.getConnection();

		List<Log> logList = new ArrayList<>();
		Log log = new Log();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getBoolean(ISACCEPTED) == isAccepted) {
					log = new Log(
							rs.getInt(ID),
							rs.getTimestamp(LOGTIME),
							rs.getBoolean(ISACCEPTED),
							rs.getString(CATEGORY).trim(),
							rs.getInt(BALANCE)*0.01,
							rs.getInt(EMP_ID),
							rs.getInt(FIN_ID)
							);
					
					logList.add(log);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return logList;
	}

	@Override
	public List<Log> selectAllLogs() {
		String sql = "SELECT * FROM logs";
		Connection connection = ConnectionFactory.getConnection();

		List<Log> logList = new ArrayList<>();
		Log log = new Log();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				log = new Log(
						rs.getInt(ID),
						rs.getTimestamp(LOGTIME),
						rs.getBoolean(ISACCEPTED),
						rs.getString(CATEGORY).trim(),
						rs.getInt(BALANCE)*0.01,
						rs.getInt(EMP_ID),
						rs.getInt(FIN_ID)
						);
				
				logList.add(log);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return logList;
	}

}
