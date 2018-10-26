<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<head>
		<title>Home</title>
		<base href="/" />
	</head>
	<body>
		<h1>Welcome</h1>
		
		<c:choose>
			<c:when test="${currentUserName ne null}">
			<a href="cave/welcome">Enter Cave</a><span>|</span>
				<strong>Welcome! ${currentUserName}</strong>,
				<a href="logout">Logout</a>
			</c:when>
			<c:otherwise>
				<a href="login">SignIn</a>
			</c:otherwise>
		</c:choose>
	</body>
</html>