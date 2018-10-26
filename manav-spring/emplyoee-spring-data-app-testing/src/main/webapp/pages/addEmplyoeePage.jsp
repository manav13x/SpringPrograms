<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><html>
<head>
<title>Add Emplyoee</title>
<link href="styles/site.css" rel="stylesheet" />
</head>
<body>
	<h2>Emplyoee Form</h2>
	<form:form modelAttribute="emplyoee" action="addEmplyoee" method="POST">
		<table>
			<tr>
			<td><form:input path="empId" type="hidden" /> <form:errors
						path="empId" ></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /> <form:errors
						path="firstName"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /> <form:errors
						path="lastName"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="hra">HRA</form:label></td>
				<td><form:input path="hra" /> <form:errors path="hra"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="basic">BASIC</form:label></td>
				<td><form:input path="basic" /> <form:errors path="basic"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td><form:radiobuttons items="${genders}" path="gender" /> <form:errors
						path="gender"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="dept">Department</form:label></td>
				<td><form:select path="dept">
						<form:option value="">-----Select--------</form:option>
						<form:options items="${possibDept}" />
					</form:select> <form:errors path="dept"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="emailId">Email</form:label></td>
				<td><form:input path="emailId" /> <form:errors path="emailId"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="mobileNumber">Mobile Number</form:label>
				</td>
				<td><form:input path="mobileNumber" /> <form:errors
						path="mobileNumber"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date Of Birth</form:label></td>
				<td><form:input type="date" path="dateOfBirth" /> <form:errors
						path="dateOfBirth"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<button>Add Emplyoee</button>
				</td>
			</tr>
		</table>
	</form:form>
	
	<a href="home">Go To Home</a>
</body>
</html>