package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.EmployeeDAO;
import com.test.dao.EmployeeDAOImpl;
import com.test.model.Employee;


@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO emp = new EmployeeDAOImpl();
       
    
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch(action) {
			case "/new":
				showNewEmployee(request,response);
				break;
			
			case "/add":
				insertNewEmployee(request,response);
				break;
				
			case "/delete":
				deleteEmployee(request,response);
				break;
				
			case "/edit":
				editEmployee(request,response);
				break;
				
			case "/update":
				updateEmployee(request,response);
				break;
				
			default:
				listEmployee(request,response);
				break;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listEmployee(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException{
		List<Employee> list = emp.listAllEmployee();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListEmployee.jsp");
		dispatcher.forward(request, response);
	
	}
	
	private void showNewEmployee(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddEmployee.jsp");
		dispatcher.forward(request, response);
	
	}
	private void insertNewEmployee(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException, SQLException{
		
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		Float salary = Float.parseFloat(request.getParameter("salary"));
		
		Employee e = new Employee(name, designation, salary);
		emp.insertEmployee(e);
		response.sendRedirect("list");
		
		
	
	}
	

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee e = new Employee(id);
		emp.deleteEmployee(e);
		response.sendRedirect("list");
		
		
	}
	
	private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee e = emp.getEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddEmployee.jsp");
		request.setAttribute("employee", e);
		dispatcher.forward(request, response);
		
	}
	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		Float salary = Float.parseFloat(request.getParameter("salary"));
		
		Employee e = new Employee(id, name, designation, salary);
		emp.updateEmployee(e);
		response.sendRedirect("list");
		
		
	}



}
