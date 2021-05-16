<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List - Spring Boot Web Application Example</title>
</head>
<body>
    <h1 align="center">Accounts</h1>
    <br/>
    <table border="1" cellpadding="10">
        <tr>
            <th>Product ID</th><th>Name</th><th>Description</th><th>Unit Price</th><th>Units in Stock</th>
        </tr>
        <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.unitPrice}</td>
            <td>${product.unitsInStock}</td>
        </tr>    
        </c:forEach>
    </table>
</body>
</html>