<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HTML-Formularausgabe mittels JSP, Servlet und JavaBean</title>
		<base href="${pageContext.request.requestURI}"/>
	</head>
	<body>
		<%-- Fehler provozieren
		<% String irgendwas = null;	out.println(irgendwas.toString()); %>
		--%>
		
		<h2>HTML-Formularausgabe mittels JSP, Servlet und JavaBean</h2>
		<h3>Ihre Eingaben</h3>
		<br><b>Email: </b>${form.email}
		<br><b>Password: </b>${form.password}
		<br><b>Ihre Anmerkung: </b>${form.anmerkung}
	</body>
</html>
