<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> A Web Application in MVC Design Pattern | JDBC | CRUD Operation</h1>
<a href="<%= request.getContextPath() %>/InsertData?page=insertdata"> CREATE Operation</a>
<br>
<a href="<%= request.getContextPath() %>/RetriveData?page=retrivedata">Retrieve data</a>
<br>
<a href="<%= request.getContextPath() %>/UpdateData?page=updateData">Update Data</a>
<br>
</body>

</html>
