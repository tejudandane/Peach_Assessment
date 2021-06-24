<%@page import="com.java.dao.ShoeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoe Vendor</title>
</head>
<body>
<h1> Shoe Vendor Insert</h1>
<form method="post" action="ShoeController">
<table>
<tr>

<tr>

<td><input type="text" name="id" value="<%=ShoeDAO.getIds() %>" hidden="hidden" ></td>

</tr>
<tr>
<td>Vendor Name:</td>
<td><input type="text" name="name"></td>

</tr>

<tr>
<td>Vendor Address:</td>
<td><input type="text" name="address"></td>

</tr>

<tr>
<td>
<input type="submit" value="Save">
</td>
</tr>

</table>

</form>
<a href="ViewServlet">Shoe Vendor Show</a>
</body>
</html>