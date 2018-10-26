<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Emplyoees List</title>
<link href="styles/site.css" rel="stylesheet" />
</head>
<body>
	<h3>Emplyoee List</h3>
	<c:choose>
		<c:when test="${emplyoees eq null or emplyoees.size() eq 0 }">
			<h3>No Records Found</h3>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Emplyoee#</th>
					<th>Name</th>
					<th>Mobile Number</th>
					<th>Email</th>
					<th>DOB</th>
					<th>HRA</th>
					<th>Department</th>
					<th>BASIC</th>
				</tr>
				<tr>
					<c:forEach items="${emplyoees}" var="emplyoee">
						<tr>
							<td>${emplyoee.empId}</td>
							<td>${emplyoee.firstName}  ${emplyoee.lastName}</td>
							<td>${emplyoee.mobileNumber}</td>
							<td>${emplyoee.emailId}</td>
							<td>${emplyoee.dateOfBirth}</td>
							<td>${emplyoee.hra}</td>
							<td>${emplyoee.dept}</td>
							<td>${emplyoee.basic}</td>
							<c:if test="${currentUserName eq 'admin'}">
								<td><a href="editEmp?empId=${emplyoee.empId}">Edit</a></td><span>|</span>
								<td><a href="deleteEmp?empId=${emplyoee.empId}">Delete</a></td>
							</c:if>

						</tr>
					</c:forEach>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>

	<a href="home">Go To Home</a>
</body>
</html>