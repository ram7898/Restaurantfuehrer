<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HTML-Formularausgabe mittels JSP, Servlet und JavaBean</title>
	</head>
	<body>
		<%-- Fehler provozieren
		<% String irgendwas = null;	out.println(irgendwas.toString()); %>
		--%>
		
		<h2>HTML-Formularausgabe mittels JSP, Servlet und JavaBean</h2>
		<h3>Ihre Eingaben</h3>
		<br><b>Titel: </b>${form.titel}
		<br><b>Name: </b>${form.nname}
		<br><b>Vorname: </b>${form.vname}
		<br><b>Email: </b>${form.email}
		<br><b>Postleitzahl: </b>${form.plz}
		<br><b>Wohnort: </b>${form.ort}
		<br><b>Straße: </b>${form.straße}
		<br><b>Hausnummer: </b>${form.hausnummer}
		<br><b>Ihre Anmerkung: </b>${form.anmerkung}
	</body>
</html>
