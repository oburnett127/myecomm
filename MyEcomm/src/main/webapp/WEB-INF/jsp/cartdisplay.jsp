<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View My Cart</title>
</head>
<body>
    <h1 align="center">Accounts</h1>
    <br/>
    <table border="1" cellpadding="10">
        <tr>
            <th>Product Name</th><th>Description</th><th>Unit Price</th>
        </tr>
        <tr>
        <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.unitPrice}</td>
        </tr>    
        </c:forEach>
    </table>
</body>
</html>