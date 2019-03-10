<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Success page</title>
<script type="text/javascript">
function add() 
{
 alert("Add new");
 document.succ.action="regist";
 alert("Add new2");
 document.succ.submit();
} 
function edt() 
{
 alert("Edit");
 document.succ.action="edit";
 alert=document.getElementById("id");
 document.succ.submit();    
} 
function delt() 
{
 alert("Delete");
 document.succ.action="delt";
 document.succ.submit();
} 
$(document).ready(function(){
	
	$("input:radio").change(function () {
		$("#btnedit").prop("disabled", false);
		$("#btndelete").prop("disabled", false);
		
	});
	
});
</script>
</head>
<body>
<div class="container">
  <h2>All Records</h2>
<div class="table-responsive">          
  <table class="table">
    <thead>
<tr>
<th>Select</th>
<th>Name</th>
<th>UserName</th>
<th>Password</th>
</tr>
</thead>
    <tbody>
<form name="succ">
<c:forEach items="${data}" var="s">
<tr>
<td><input type="radio" name="id" value="${s.id}" class="check"></td>
<td>${s.name}</td>
<td>${s.uname}</td>
<td>${s.pass}</td></tr>
</c:forEach>
</table>
</form>
</tbody>
  </table>
  </div>
</div>

 <div class="container" >
 <div class="center">
  <h2></h2>
  <p></p>
  <div class=""btn-group btn-group-lg"">
   <button type="button"  onclick="add()" class="btn btn-primary">AddNew</button>
   <button type="submit"   onclick="edt()" class="btn btn-primary" id="btnedit" disabled="disabled">Edit</button>
   <button type="submit"  onclick="delt()" class="btn btn-primary" id="btndelete" disabled="disabled">Delete</button>
  </div>
  </div>
</div>
</body>
</html>