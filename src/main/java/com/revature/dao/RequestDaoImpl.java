package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.util.ConnectionFactory;

public class RequestDaoImpl implements RequestDao {
	
	final String ID = "req_id";
	final String SENTTIME = "senttime";
	final String CATEGORY = "category";
	final String BALANCE = "balance";
	final String EMP_ID = "emp_id";

	@Override
	public void insertRequest(Request req) {
		String sql = "INSERT INTO requests (senttime,category,balance,emp_id) VALUES (?,?,?,?)";
		Connection connection = ConnectionFactory.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setTimestamp(1, req.getTs());
			ps.setString(2, req.getCategory());
			ps.setInt(3, (int)(req.getBalance()*100));
			ps.setInt(4, req.getMy_emp_id());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Request selectRequestById(int id) {
		String sql = "SELECT * FROM requests WHERE req_id = ?";
		Connection connection = ConnectionFactory.getConnection();
		
		Request req = new Request();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			req = new Request(
					rs.getInt(ID),
					rs.getTimestamp(SENTTIME),
					rs.getString(CATEGORY).trim(),
					rs.getInt(BALANCE)*0.01,
					rs.getInt(EMP_ID)
					);
			
		} catch (Exception e) {
			e.printStackTrace();
			req = null;
		}
		
		return req;
	}

	@Override
	public List<Request> selectRequestsByEmployeeId(Employee emp) {
		String sql = "SELECT * FROM requests WHERE emp_id = "
				+ "(SELECT emp_id FROM employees WHERE emp_id = ?);";
		
		Connection connection = ConnectionFactory.getConnection();
		List<Request> requestList = new ArrayList<>();
		Request req = new Request();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setInt(1, emp.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				req = new Request(
						rs.getInt(ID),
						rs.getTimestamp(SENTTIME),
						rs.getString(CATEGORY).trim(),
						rs.getInt(BALANCE)*0.01,
						rs.getInt(EMP_ID)
						);
				
				requestList.add(req);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			requestList = null;
		}
		
		return requestList;
	}

	@Override
	public Request selectOldestRequest() {
		String sql = "SELECT * FROM requests WHERE senttime = (SELECT MIN(senttime) FROM requests)";
		Connection connection = ConnectionFactory.getConnection();

		Request req = new Request();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			req = new Request(
					rs.getInt(ID),
					rs.getTimestamp(SENTTIME),
					rs.getString(CATEGORY).trim(),
					rs.getInt(BALANCE)*0.01,
					rs.getInt(EMP_ID)
					);
			
		} catch (Exception e) {
			e.printStackTrace();
			req = null;
		}
		
		return req;
	}

	@Override
	public List<Request> selectAllRequests() {
		String sql = "SELECT * FROM requests ORDER BY senttime;";
		
		Connection connection = ConnectionFactory.getConnection();
		List<Request> requestList = new ArrayList<>();
		Request req = new Request();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				req = new Request(
						rs.getInt(ID),
						rs.getTimestamp(SENTTIME),
						rs.getString(CATEGORY).trim(),
						rs.getInt(BALANCE)*0.01,
						rs.getInt(EMP_ID)
						);
				
				requestList.add(req);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			requestList = null;
		}
		
		return requestList;
	}

	@Override
	public void deleteRequest(Request req) {
		String sql = "DELETE FROM requests WHERE req_id = ?";
		Connection connection = ConnectionFactory.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, req.getId());
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
