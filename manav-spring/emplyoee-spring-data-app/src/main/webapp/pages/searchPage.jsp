<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Search Page</title>
<link href="styles/site.css" rel="stylesheet" />
</head>
<body>
	<h2>Search Emplyoee</h2>
	<form action="searchEmplyoee" method="POST">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <label>Search For:<input
			type="text" name="srhValue" /></label>
		<button name="field" value="mobile">By Mobile</button>
		<button name="field" value="email">By Email</button>
		<button name="field" value="lnm">By Last Name</button>
		<button name="field" value="dp">By Department</button>
		<button name="field" value="dob">By Date Of Birth</button>
	</form>

	<c:if test="${pageTitle ne null }">
		<h2>${pageTitle }</h2>
		<c:choose>
			<c:when test="${result ne null}">
				<table>
					<tr>
						<td><strong>Emplyoee#</strong></td>
						<td>${result.empId }</td>
					</tr>
					<tr>
						<td><strong>Name</strong></td>
						<td>${result.firstName }${result.lastName }</td>
					</tr>
					<tr>
						<td><strong>Mobile</strong></td>
						<td>${result.mobileNumber }</td>
					</tr>
					<tr>
						<td><strong>Email Id</strong></td>
						<td>${result.emailId }</td>
					</tr>
					<tr>
						<td><strong>Date Of Birth</strong></td>
						<td>${result.dateOfBirth }</td>
					</tr>
					<tr>
						<td><strong>HRA</strong></td>
						<td>${result.hra }</td>
					</tr>
					<tr>
						<td><strong>DEPT</strong></td>
						<td>${result.dept }</td>
					</tr>
					<tr>
						<td><strong>BASIC</strong></td>
						<td>${result.basic }</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${results ne null and results.size() ne 0}">
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
						<c:forEach items="${results}" var="emplyoee">
							<tr>
								<td>${emplyoee.empId}</td>
								<td>${emplyoee.firstName}${emplyoee.lastName}</td>
								<td>${emplyoee.mobileNumber}</td>
								<td>${emplyoee.emailId}</td>
								<td>${emplyoee.dateOfBirth}</td>
								<td>${emplyoee.hra}</td>
								<td>${emplyoee.dept}</td>
								<td>${emplyoee.basic}</td>
							</tr>
						</c:forEach>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<h3>No Such Records Found</h3>
			</c:otherwise>
		</c:choose>
	</c:if>

	<a href="home">Go To Home</a>
	<br />
	<a href="logout">LogOut</a>
</body>
</html>