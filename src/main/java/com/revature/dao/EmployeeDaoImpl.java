package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	
	final String ID = "emp_id";
	final String USERNAME = "emp_username";
	final String PASSWORD = "emp_password";
	final String FIRSTNAME = "emp_firstname";
	final String LASTNAME = "emp_lastname";

	public Employee selectEmployeeById(int id) {
		String sql = "SELECT * FROM employees WHERE emp_id = ?";
		Connection connection = ConnectionFactory.getConnection();
		
		Employee emp = new Employee();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			emp = new Employee(
					rs.getInt(ID),
					rs.getString(USERNAME).trim(),
					rs.getString(PASSWORD).trim(),
					rs.getString(FIRSTNAME).trim(),
					rs.getString(LASTNAME).trim(),
					null,
					null
					);
			
		} catch (PSQLException psqlE) {
			emp = null;
		} catch (Exception e) {
			e.printStackTrace();
			emp = null;
		}
		
		return emp;
	}

	public Employee selectEmployeeByName(String name) {
		String sql = "SELECT * FROM employees WHERE emp_username = ?";
		Connection connection = ConnectionFactory.getConnection();
		
		Employee emp = new Employee();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			emp = new Employee(
					rs.getInt(ID),
					rs.getString(USERNAME).trim(),
					rs.getString(PASSWORD).trim(),
					rs.getString(FIRSTNAME).trim(),
					rs.getString(LASTNAME).trim(),
					null,
					null
					);
			
		} catch (PSQLException psqlE) {
			emp = null;
		} catch (Exception e) {
			e.printStackTrace();
			emp = null;
		}
		
		return emp;
	}

	public List<Employee> selectAllEmployees() {
		
		String sql = "SELECT * FROM employees";
		Connection connection = ConnectionFactory.getConnection();
		
		List<Employee> employeeList = new ArrayList<>();
		Employee emp = new Employee();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employee(
						rs.getInt(ID),
						rs.getString(USERNAME).trim(),
						rs.getString(PASSWORD).trim(),
						rs.getString(FIRSTNAME).trim(),
						rs.getString(LASTNAME).trim(),
						null,
						null
						);
				
				employeeList.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			employeeList = null;
		}
		
		return employeeList;
	}

}
