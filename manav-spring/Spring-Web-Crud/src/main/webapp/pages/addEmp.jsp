<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CRUD</title>
<link href="styles/site.css" rel="stylesheet">
</head>
<body>
	<header>
		<h1>Spring Data Web MVC App</h1>
	</header>
	<section>
		<h3>Add Employee</h3>
		<form:form action="addEmp" method="post" modelAttribute="emp">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input path="name" required="required" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><form:input path="salary" type="decimal"
							required="requried" /></td>
				</tr>
				<tr>
					<td>Date Of Joining</td>
					<td><form:input path="dateOfJoining" type="date"
							required="required" /></td>
				</tr>
				<tr>
					<td colspan="2"><button>Add</button></td>
				</tr>
			</table>
		</form:form>
	</section>
	<footer> </footer>
</body>
</html>
