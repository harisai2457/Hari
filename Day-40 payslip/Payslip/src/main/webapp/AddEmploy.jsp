<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<jsp:useBean id="beanDao" class="com.infinite.hib.PayrollDAO"></jsp:useBean>
<form method="get" action="AddEmploy.jsp">
<center>
Enter Name :
<input type="text" name="empName"/><br/><br/>
Select Gender : &nbsp&nbsp
<input type="radio" name="gender" value="MALE">Male
<input type="radio" name="gender" value="FEMALE">Female<br/><br/>   
Salary :
<input type="text" name="salary"><br/><br/>
<input type="submit" value="Add" />
</center>
</form>  <c:if test="${param.salary != null}">
<jsp:useBean id="beanEmploy" class="com.infinite.hib.Employ" />
<jsp:setProperty property="*" name="beanEmploy"/> 
<c:out value="${beanDao.addEmploy(beanEmploy)}"/>
</c:if>
</body>
</html>