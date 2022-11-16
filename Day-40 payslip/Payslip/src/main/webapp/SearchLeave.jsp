<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.infinite.hib.LeaveTable" %>
<%@ page import="java.util.List" %>
 <%@ page import="com.infinite.hib.PayrollDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="empNo" value="${param.empNo}"/>
 <jsp:useBean id="beanDao" class="com.infinite.hib.PayrollDAO"/>                             
<form action="SearchLeave.jsp" method="post">
 <input type="number" name="empNo"/><br/><br/>
 <input type='submit' value='SearchLeave' >
 
 <table border='3'>
<tr>
              <th>leaveId </th>
                <th>empNo </th>

               <th>leaveStartDate</th>

                <th>leaveEndDate</th>

                <th>noOfDays</th>

                 <th>leaveReason</th>

                 <th>lossOfPay</th>
                       </tr>
       <c:set var="empNo" value="${param.empNo}"/>

                  <c:forEach var="leave" items="${beanDao.searchLeave(param.empNo)}">
                  <c:if test="${param.empNo != null}">

<tr>

        <td><c:out value="${leave.leaveId}"/> </td>

        <td><c:out value="${leave.empNo}"/> </td>

        <td><c:out value="${leave.leaveStartdate}"/> </td>

        <td><c:out value="${leave.leaveEnddate}"/> </td>

        <td><c:out value="${leave.noOfDays}"/> </td>

        <td><c:out value="${leave.leaveReason}"/> </td>

        <td><c:out value="${leave.lossOfPay}"/> </td>
</tr>
</c:if>
        </c:forEach>

                 

                 

 </table>

  <br/>

  </form>


</body>
</html>