<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here plz</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<form action="registration" method="post">
	
		<label for="firstName">First Name :</label> <input name="firstName">
			<br><br>
		<label for="lastName">Last Name :</label> <input name="lastName">
			<br><br>
		<label for="email">Email :</label> <input name="email">
			<br><br>
		<label for="password">Password : </label> <input name="password">
			<br><br>
		<input type="submit" value="submit">
	</form>




	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
