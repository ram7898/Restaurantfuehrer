<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Erfolgreiche Aktualisierung eines Eintrags in DB</title>
		<base href="${pageContext.request.requestURI}"/>
	</head>
	<body>
		<h2>Erfolgreiche Aktualisierung eines Eintrags in DB</h2>
		<h3>Aktualisierte Daten</h3>
		<br><em>Id: </em>${form.id}
		<br><em>E-Mail-Adresse: </em>${form.email}
		<br><em>Passwort: </em>${form.password}
	</body>
</html>