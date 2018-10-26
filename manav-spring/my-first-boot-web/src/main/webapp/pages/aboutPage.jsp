<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>My Spring Web About Page</title>
</head>
<body>
	<h1>About Us</h1>

	<p><strong>Web Master:</strong><em>${webmaster}</em></p>
	<p><strong>Developer Team:</strong>
	<ol>
		<c:forEach items="${Devs}" var="ele">
		<li>${ele }</li>
	</c:forEach>
	</ol>
	</p>
	
	<p>
		<strong>Admin mail:</strong><em>${admin}</em>
	</p>
	<a href="home">PoPo Go back Home</a>
</body>
</html>