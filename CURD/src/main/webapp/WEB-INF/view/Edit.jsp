<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdatePage</title>
</head>
<body bgcolor="lightblue"><center>
<h1>Update Information</h1>
<form action="updt">

<table cellspacing="20">
<tr><td>
<tr><th></th><td><input type="hidden" name="id" value="${data.id}"></td></tr>
<tr><th>Name</th><td><input type="text" name="name" value="${data.name}"></td></tr>
<tr><th>UserName</th><td><input type="text" name="uname" value="${data.uname}"></td></tr>
<tr><th>Password</th><td><input type="text" name="pass" value="${data.pass}"></td></tr>

</table>
<input type="submit" value="Update">
</form>
</center></body>
</html>