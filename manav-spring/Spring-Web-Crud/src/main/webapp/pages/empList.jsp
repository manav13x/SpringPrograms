<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
		<section>
			<h3>List Of Employees</h3>
			<a href="addEmp">Add New Record</a>
			<c:choose>
				<c:when test="${emps eq null or emps.size() eq 0 }">
					<h4>No Records</h4>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<th>Emp#</th>
							<th>Name</th>
							<th>Salary</th>
							<th>Date Of Joining</th>
						</tr>
						<c:forEach var="emp" items="${emps }">
							<tr>
								<td>${emp.empId }</td>
								<td>${emp.name }</td>
								<td>${emp.salary }</td>
								<td>${emp.dateOfJoining }</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</section>
	</section>
	<footer> </footer>
</body>
</html>
