package com.revature.dao;

import java.util.List;

import com.revature.models.FinManager;

public interface FinManagerDao {

	public FinManager selectFinManagerById(int id);
	public FinManager selectFinManagerByName(String name);
	public List<FinManager> selectAllFinManagers();
}
