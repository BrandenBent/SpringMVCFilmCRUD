<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">
<title>Add Film</title>
</head>
<body>
<h1>Add New Film</h1>

  <form:form method="POST" action="addfilm.do" modelAttribute="film">
		
		Title: <input type="text" path="title" required /><br>
		Description: <input type="text"	path="description" /><br>
		Release Year: <input type="number" path="releaseYear" min="1950" max="2020" /><br>
		Language
		<select path="language">
		<option value="English">English</option>
		<option value="Italian">Italian</option>
		<option value="Japanese">Japanese</option>
		<option value="Mandarin">Mandarin</option>
		<option value="French">French</option>
		<option value="German">German</option>
		</select><br>
		Rental Duration: <input type="number" min="3" max="7" name="rentalDuration" required/> <br>
		Rental Rate
		<select required>
		<option value="0.99">0.99</option>
		<option value="1.99">1.99</option>
		<option value="2.99">2.99</option>
		<option value="3.99">3.99</option>
		<option value="4.99">4.99</option>
		</select><br>
		Length: <input type="number" path="length"	min="30" max="300"/> <br>
		Replacement Cost: <input path="replacementCost" type="number" min="2.99" max="50.00" required/> <br>
		Rating <select path="rating">
  		<option value="G">G</option>
 		<option value="PG">PG</option>
  		<option value="PG13">PG13</option>
 		<option value="NC17">NC-17</option>
 		<option value="R">R</option>
		</select><br>
		Special Features<br> 
		<select path="specialFeatures" multiple>
		<option value="Deleted Scenes">Deleted Scenes</option>
		<option value="Trailers">Trailers</option>
		<option value="Commentaries">Commentaries</option>
		<option value="Behind The Scenes">Behind The Scenes</option>
		</select><br><br>
		
		<input type="submit" value="Submit" />  <input type="button" onclick="history.back()" value="Back">
		</form:form> 
</body>
</html>