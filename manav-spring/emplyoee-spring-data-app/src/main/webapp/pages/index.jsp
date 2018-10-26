<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Home Page</title>
<link href="styles/site.css" rel="stylesheet" />
</head>
<body>
	<h1>Emplyoees Application</h1>

	<a href="emplyoeeList">Emplyoee List</a>
	<c:choose>
		<c:when test="${currentUserName ne null}">
			<a href="searchEmplyoee">Search Emplyoee List</a>
			<br />
			<br />
			<c:if test="${currentUserName eq 'admin'}">
				<a href="addEmplyoee">Add Emplyoee</a>
				<br />
			</c:if>
			<strong>Welcome! ${currentUserName}</strong>,
				<a href="logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="login">SignIn</a>
		</c:otherwise>
	</c:choose>


</body>
</html>