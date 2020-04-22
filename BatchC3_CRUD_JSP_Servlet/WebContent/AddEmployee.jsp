<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.top{
		overflow: auto;
		background-color: #e9e9e9;
		height: 25px;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

	<h1 align = "center">Employee Management System </h1>
	<div class="top">
		<a href="index.jsp style= padding: 15px; ">Home</a>
		<a href="list" style="margin-left: 50px; padding: 15px;">List</a>
		<a href="new" style="margin-left: 50px;padding: 15px;">Add</a>
	
	</div >
	
	<div align ="center" style="margin-top: 20px;">
		<c:if test="${employee != null}">
			<form action ="update" method = "post"> 
		</c:if>
		
		<c:if test="${employee == null}">
			<form action ="add" method = "post"> 
		</c:if>
		
			<input type = "hidden" name= "id" value="${employee.id}" >
		
			<table>
				<tr>
					<td>Name</td>
					<td><input type= "text" name = "name" value="${employee.name}"></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><input type= "text" name = "designation" value="${employee.designation}"></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type= "text" name = "salary" value="${employee.salary}"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<c:if test="${employee != null}">
							<input type= "submit" value = "update">
						</c:if>
		
						<c:if test="${employee == null}">
							<input type= "submit" value = "submit">
						</c:if>
					</td>
				</tr>
			
			</table>
		
		</form>
	
	</div>
	
	<div style= "background-color: #e9e9e9; margin-top: 700px;">
		<h5 align ="center"> @LLC All license required</h5>
	</div>

</body>
</html>