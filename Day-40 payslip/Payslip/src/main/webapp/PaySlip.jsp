<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="dao" class="com.infinite.hib.PayrollDAO" />
    <form action="PaySlip.jsp">
 Employ No: <input type="number" name="empNo"><br />
        <br /> Month: <select name="month">
            <option value="11">November</option>
            
        </select><br />
        <br /> <input type="submit" value="Submit" /><br />
        <br />
    </form>
</body>
<c:if test="${param.empNo != null }">
    <c:set var="id" value="${param.empNo}" />
    <c:set var="beanmonth" value="${param.month}" />
    <c:set var="employ" value="${dao. searchemploy(Id)}" />
    <jsp:useBean id="leave" class="com.infinite.hib.LeaveTable" />
    <c:set var="pay" value="${dao.lossOfPay(id,beanmonth)}" />
    <h4>Employ Id:${id}</h4>
    <table style="width: 60%">
        <tr>
            <th></th>
            <th></th>
       </tr>
       <tr>
            <td>Earnings
                <hr>
            </td>
            <td>Deduction
                <hr>
            </td>
        </tr>
        <tr>
            <td>BASIC:${employ.salary}</td>
            <td>PF:${employ.pf}</td>
        </tr>
        <tr>
            <td>HRA:${employ.hra}</td>
            <td>Tax:${employ.tax}</td>
        </tr>
        <tr>
            <td>DA:${employ.da}</td>
            <td>Loss Of Pay:${pay}</td>
        </tr>
        <tr>
            <td>TA:${employ.ta}</td>
             </tr>
              <tr>
            <td><hr>Total Earning: ${employ.gross}
                <hr></td>
            <td><hr>Total Deduction:<c:out
                    value="${employ.pf+employ.tax+pay }" />
                <hr></td>
        </tr>
        <tr>
            <c:set var="total" value="${employ.pf+employ.tax+pay }" />
            <td>Net Pay :<c:out value="${employ.gross-total}" /></td>
        </tr>



   </table>
</c:if>
</html>