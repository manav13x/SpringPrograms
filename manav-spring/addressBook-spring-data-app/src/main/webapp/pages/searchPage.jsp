<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Search Page</title>
<link href="styles/site.css" rel="stylesheet" />
</head>
<body>
	<h2>Search Contact</h2>
	<form action="searchContact" method="POST">
		<label>Search For:<input type="text" name="srhValue" /></label>
		<button name="field" value="mobile">By Mobile</button>
		<button name="field" value="email">By Email</button>
		<button name="field" value="lnm">By Last Name</button>
	</form>

	<c:if test="${pageTitle ne null }">
		<h2>${pageTitle }</h2>
		<c:choose>
			<c:when test="${result ne null}">
				<table>
					<tr>
						<td><strong>Contact#</strong></td>
						<td>${result.contactId }</td>
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
				</table>
			</c:when>
			<c:when test="${results ne null and results.size() ne 0}">
				<table>
					<tr>
						<th>Contact#</th>
						<th>Name</th>
						<th>Mobile</th>
						<th>Email</th>
						<th>Date Of Birth</th>
					</tr>
					<c:forEach items="${results }" var="contact">
						<tr>
							<td>${contact.contactId }</td>
							<td>${contact.firstName }${contact.lastName }</td>
							<td>${contact.mobileNumber }</td>
							<td>${contact.emailId }</td>
							<td>${contact.dateOfBirth }</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h3>No Such Records Found</h3>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>