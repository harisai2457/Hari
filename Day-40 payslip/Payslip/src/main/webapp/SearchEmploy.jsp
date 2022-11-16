<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.infinite.hib.Employ" %>
    <%@ page import="java.util.List" %>
     <%@ page import="com.infinite.hib.PayrollDAO" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
                
                <c:set var="empNo" value="${param.empNo}"/>
                
                <jsp:useBean id="beanDao" class="com.infinite.hib.PayrollDAO"/>
                                
                
                <form action="SearchEmploy.jsp" method="post">
                Employ No:
                <input type="number" name="empNo"/><br/><br/>
                
                <input type='submit' value='SearchEmploy' >
                
                                
                 <c:if test="${param.empNo != null}">
                <table border='3'>
                                <tr>
                                <th>empNo </th>
                                <th>empName </th>
                                <th>gender</th>
                                <th>salary</th>
                                <th>hra</th>
                                <th>da</th>
                                <th>ta</th>
                                <th> tax</th>
                                <th>gross </th>
                                <th>netPay </th>
                                <th>leaveAvailable </th>
                    </tr>
                
                    <c:set var="empNo" value="${param.empNo}"/>
                  <c:forEach var="employ" items="${beanDao.searchEmploy(param.empNo)}">
<tr>
            <td><c:out value="${employ.empNo}"/> </td>
                                                <td><c:out value="${employ.empName}"/> </td>
                                                <td><c:out value="${employ.gender}"/> </td>
                                                <td><c:out value="${employ.salary}"/> </td>
                                                <td><c:out value="${employ.hra}"/> </td>
                                                <td><c:out value="${employ.da}"/> </td>
                                                <td><c:out value="${employ.ta}"/> </td>
                                                <td><c:out value="${employ.tax}"/> </td>
                                                <td><c:out value="${employ.gross}"/> </td>
                                                <td><c:out value="${employ.netPay}"/> </td>
                                                <td><c:out value="${employ.leaveAvailable}"/> </td>
                                                <td><input type='checkbox' name="empNo" value="${employ.empNo}" /></td>
                                                </tr>
                                                
                  
                  
                  </c:forEach>
                  </c:if>



               </table>
                <br/>
                 </form>
</body>
</html>