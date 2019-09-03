<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
	<h1>TEST CONNECTION KEYWORD</h1>

	<a href="index.html">Home</a>
	<h2>Keyword Search Results</h2>
	<br>
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<h3>Film Details:</h3>
				<c:forEach var="film" items="${film}">
					<li>"${film}"</li>
				</c:forEach>
				<!-- <h4>Actors in Film:</h4> -->
				<!-- This code may be uncommented to list all actors in the description films -->
				<%-- <c:forEach var="actor" items="${film}">
					<c:forEach var="film" items="${actors }">
					<li>"${actor}"</li>
					</c:forEach>
				</c:forEach> --%>
				<br>
				<form action="updated.do" method="GET">
					<br>
					<button type="submit">Update/Delete Film</button>
					<%-- <input type="hidden" name="id" value="${film.id}" /> --%>
				</form>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No films found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>