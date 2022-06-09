package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import com.revature.models.FinManager;
import com.revature.util.ConnectionFactory;

public class FinManagerDaoImpl implements FinManagerDao {

	final String ID = "fin_id";
	final String USERNAME = "fin_username";
	final String PASSWORD = "fin_password";
	final String FIRSTNAME = "fin_firstname";
	final String LASTNAME = "fin_lastname";
	
	@Override
	public FinManager selectFinManagerById(int id) {
		String sql = "SELECT * FROM finmanagers WHERE fin_id = ?";
		Connection connection = ConnectionFactory.getConnection();
		
		FinManager fin = new FinManager();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			fin = new FinManager(
					rs.getInt(ID),
					rs.getString(USERNAME).trim(),
					rs.getString(PASSWORD).trim(),
					rs.getString(FIRSTNAME).trim(),
					rs.getString(LASTNAME).trim()
					);
			
		} catch (PSQLException psqlE) {
			fin = null;
		} catch (Exception e) {
			e.printStackTrace();
			fin = null;
		}
		
		return fin;
	}

	@Override
	public FinManager selectFinManagerByName(String name) {
		String sql = "SELECT * FROM finmanagers WHERE fin_username = ?";
		Connection connection = ConnectionFactory.getConnection();
		
		FinManager fin = new FinManager();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			fin = new FinManager(
					rs.getInt(ID),
					rs.getString(USERNAME).trim(),
					rs.getString(PASSWORD).trim(),
					rs.getString(FIRSTNAME).trim(),
					rs.getString(LASTNAME).trim()
					);
			
		} catch (PSQLException psqlE) {
			fin = null;
		} catch (Exception e) {
			e.printStackTrace();
			fin = null;
		}
		
		return fin;
	}

	@Override
	public List<FinManager> selectAllFinManagers() {
		String sql = "SELECT * FROM finmanagers";
		Connection connection = ConnectionFactory.getConnection();
		
		List<FinManager> finmanagerList = new ArrayList<>();
		FinManager fin = new FinManager();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				fin = new FinManager(
						rs.getInt(ID),
						rs.getString(USERNAME).trim(),
						rs.getString(PASSWORD).trim(),
						rs.getString(FIRSTNAME).trim(),
						rs.getString(LASTNAME).trim()
						);
				
				finmanagerList.add(fin);
			}
		} catch (Exception e) {
			e.printStackTrace();
			finmanagerList = null;
		}
		
		return finmanagerList;
	}

}
