<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<head>
		<title>Home</title>
		<base href="/" />
	</head>
	<body>
		<h1>Login</h1>
		<form action="login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<c:if test="${param.err eq true }">
				<p><strong>Incorrect UserNamePassword</strong></p>
			</c:if>
			<label>UserName: </label><input type="text" name="unm"/></label>
			<label>password: </label><input type="password" name="pwd"/></label>
			<button>SignIn</button>
		</form>
	</body>
</html>