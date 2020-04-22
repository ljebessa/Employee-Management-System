<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> --%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.top{
		overflow: auto;
		background-color: #e9e9e9;
		height: 25px;
}

th{
	text-align: center;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/cf83f7bba5.js" crossorigin="anonymous"></script>
</head>
<body>

	<h1 align = "center">Employee Management System </h1>
	<div class="top">
		<a href="index.jsp style= padding: 15px; ">Home</a>
		<a href="list" style="margin-left: 50px; padding: 15px;">List</a>
		<a href="new" style="margin-left: 50px;padding: 15px;">Add</a>
	
	</div>
	<div align = "center">
		<table border="1">
			<tr>
				<th> Id </th>
				<th> Employee Name </th>
				<th> Employee Designation </th>
				<th> Employee Salary </th>
				<th> Action </th>
			</tr>	
			
			<c:forEach items = "${list}" var ="emp">
				<tr>
					<td> ${emp.id} </td>
					<td> ${emp.name} </td>
					<td> ${emp.designation}</th>
					<th> ${emp.salary} </td>
					<td> 
						<a href="edit?id=${emp.id}" ><i class="fas fa-edit"></i></a>
						<a onclick="return confirm('Are you sure you want to delete')" 
						href="delete?id=${emp.id}"><i class="fas fa-trash-alt"></i></a>
					</td>
				
				</tr>
				
			</c:forEach>
			
		
		</table>
	</div>
	
	<div style= "background-color: #e9e9e9; margin-top: 700px;">
		<h5 align ="center"> @LLC All license required</h5>
	</div>

</body>
</html>