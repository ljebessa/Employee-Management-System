package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.test.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String username = "postgres";
	private String password = "rwtwqlDB1!";
	private Connection  conn;
	
	private void connect() throws SQLException {
		if(conn == null || conn.isClosed()) {
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	

	@Override
	public List<Employee> listAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			String sql = "select * from employee";
			connect();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet resultset = st.executeQuery();
			
			while(resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				String designation = resultset.getString("designation");
				Float salary = resultset.getFloat("salary");
				
				Employee e = new Employee(id, name, designation, salary);
				list.add(e);
				
			}
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public boolean insertEmployee(Employee e) {
		boolean r = false;
		
		try {
			String sql = "insert into employee(name, designation,salary) values(?,?,?)";
			connect();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, e.getName());
			st.setString(2, e.getDesignation());
			st.setFloat(3, e.getSalary());
			r = st.executeUpdate() > 0;
			st.close();
			conn.close();
			return r;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return r;
	}


	@Override
	public boolean deleteEmployee(Employee e) {
		boolean r = false;
		
		try {
			String sql = "delete from  employee where id=?";
			connect();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, e.getId());
			r = st.executeUpdate() > 0;
			st.close();
			conn.close();
			return r;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return r;
	}


	@Override
	public Employee getEmployee(int id) {
		Employee e = null;
		
		try {
			String sql = "select * from  employee where id=?";
			connect();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet resultSet = st.executeQuery();
			if(resultSet.next()) {
				String  name = resultSet.getString("name");
				String  designation = resultSet.getString("designation");
				float salary = resultSet.getFloat("salary");
				e = new Employee(id,name, designation,salary);
				
			}
			resultSet.close();
			st.close();
			conn.close();
			
		
		
		} catch (SQLException es) {
		// TODO Auto-generated catch block
			es.printStackTrace();
		}
		return e;
	
	
	}


	@Override
	public boolean updateEmployee(Employee e) {
		boolean r = false;
		try {
			String sql = "update  employee set name=?, designation=?, salary=? where id=?";
			connect();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, e.getName());
			st.setString(2, e.getDesignation());
			st.setFloat(3, e.getSalary());
			st.setInt(4, e.getId());
			
			r = st.executeUpdate() > 0;
			st.close();
			conn.close();
			return r;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return r;
	}

}
