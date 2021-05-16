<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts - Display</title>
</head>
<body>
    <h1 align="center">Accounts</h1>
    <br/>
    <table border="1" cellpadding="10">
        <tr>
            <th>Account ID</th><th>Email</th><th>First Name</th><th>Last Name</th><th>Password</th><th>Is Admin?</th>
        </tr>
        <c:forEach var="account" items="${accounts}">
        <tr>
            <td>${account.accountId}</td>
            <td>${account.emailId}</td>
            <td>${account.firstName}</td>
            <td>${account.lastName}</td>
            <td>${account.password}</td>
            <td>${account.Is Admin?}</td>
        </tr>    
        </c:forEach>
    </table>
</body>
</html>