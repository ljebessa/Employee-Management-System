package com.test.dao;

import java.util.List;

import com.test.model.Employee;

public interface EmployeeDAO {
	public List<Employee> listAllEmployee();
	public boolean insertEmployee(Employee e);
	public boolean updateEmployee(Employee e);
	public boolean deleteEmployee(Employee e);
	public Employee  getEmployee(int id);

}
