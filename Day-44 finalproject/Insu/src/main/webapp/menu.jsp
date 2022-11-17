<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Account Page</title>

<style type="text/css">
.logout
{ margin-top: -20px; margin-left: 290px; height: 30px;}
.aone    
{ margin-top: 6px; margin-left: 0px; height: 38px; width:650px; color: #d56d2d;}     
.atwo   
{ margin-top: 4px; margin-left: 10px;height: 30px; width:150px; color: #7464aa;}
</style>
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to  : 
<b>
<c:out value="${sessionScope.user}" />
</b>
<br/>
<br/><br/>
<div class="logout">
<input type="button" name="logout" value="Logout" onclick="window.location='login.html'">
</div><br/><br/>
<div class="aone" style =" background-color:palepink ">
	<div class= "atwo" style =" background-color:palepink ">
	<a href="AddLapsedDetails.jsp">AddLapsedDetails</a> 
	</div>

	<div class="atwo"style="background-color:palepink;margin-top:-30px;margin-left:170px">
	<a href="ShowLapsedDetails.jsp">ShowLapsedDetails</a>
	</div>
	
	<div class="atwo"style="background-color:palepink;margin-top:-30px;margin-left:330px">
	<a href="SearchLapsedDetails.jsp">SearchLapsedDetails</a>
	</div>
	
	<div class="atwo"style="background-color:palepink;margin-top:-30px;margin-left:490px">
	<a href="DeleteLapsedDetails.jsp">DeleteLapsedDetails</a>
	</div>
	
	
</div>


</body>
</html>