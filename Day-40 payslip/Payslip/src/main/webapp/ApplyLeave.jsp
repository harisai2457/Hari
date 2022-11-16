<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="beanDao" class="com.infinite.hib.PayrollDAO" />
<form method="get" action="ApplyLeave.jsp">
    <center>
     Enter Empno :
     <input type="number" name="empNo"><br/><br/>
     Enter LeaveStartDate :
     <input type="date" name="leaveStartdate"><br/><br/>
     Enter LeaveEndDate :
     <input type="date" name="leaveEnddate"><br/><br/>
     Enter Leave Reason :
     <input type="text" name="leaveReason"><br/><br/>
     
     <input type="submit" value="Apply"><br/><br/>
    </center>
</form>
<c:if test="${param.leaveReason != null}">
    <jsp:useBean id="LeaveTable" class="com.infinite.hib.LeaveTable" />
    <jsp:setProperty property="empNo" name="LeaveTable"/>
    
    
    <fmt:parseDate value="${param.leaveStartdate}" pattern="yyyy-MM-dd" var="cdate1"/>
        <c:set var="sqlDate1" value="${beanDao.convertDate(cdate1)}"/>
        
        <fmt:parseDate value="${param.leaveEnddate}" pattern="yyyy-MM-dd" var="cdate2"/>
        <c:set var="sqlDate2" value="${beanDao.convertDate(cdate2)}"/>
        
    <jsp:setProperty property="leaveStartdate" name="LeaveTable" value="${sqlDate1}"/>    
    <jsp:setProperty property="leaveEnddate" name="LeaveTable" value="${sqlDate2}"/>    
        
        <jsp:setProperty property="leaveReason" name="LeaveTable"/>
    
    <c:out value="${beanDao.applyLeave(LeaveTable)}"></c:out>
    </c:if>



</body>
</html>