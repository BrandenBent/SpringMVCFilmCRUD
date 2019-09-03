<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">
<title>Add Film</title>
</head>
<body>
	<h1>New Film Added</h1>
	<h1>This is the film you added...</h1>
	<c:choose>
		<c:when test="${! empty filmNew}">
			<ul>
				<li>Title: ${filmNew.title}</li>
				<li>Description: ${filmNew.description}</li>
				<li>For more information, your film's ID is -> ${filmNew.id}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>I'm sorry we couldn't add that movie at this time</p>
		</c:otherwise>
	</c:choose>
	<form action="UPDATEFILM.do" method="GET">
		<br>
		<%-- <button type="submit">Update Film</button>
		<input type="hidden" name="id" value="${filmAdd.id}" /> --%>
		<a href="index.html">Home</a>
	</form>
	<form action="UPDATEFILM.do" method="GET">
						<br>
						<button type="submit">Update/Delete Film</button>
						<input type="hidden" name="id" value="${filmNew.id}" />
					</form>
</body>
</html>
