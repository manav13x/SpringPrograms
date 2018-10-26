<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<title>Get Employee Details</title>
</head>
<body>
	<form:form action="employee" modelAttribute="emp2" method="POST">
		<div>
			<form:label path="empId">Employee Id?</form:label>
			<form:input path="empId" type="number" />
		</div>

		<div>
			<form:label path="name">Employee Name?</form:label>
			<form:input path="name" type="text" />
		</div>

		<div>
			<form:label path="basic">Employee Basic?</form:label>
			<form:input path="basic" type="decimal" />
		</div>

		<div>
			<form:label path="exp">Experience ?</form:label>
			<form:input path="exp" type="decimal" />
		</div>

		<div>
			<form:label path="dept">Department:</form:label>
			<form:select path="dept">
				<form:option value="">--SELECT--</form:option>
				<form:options items="${posibDept}" />
			</form:select>
		</div>
		<div>
			<form:label path="gender">Book Type:</form:label>
			<form:radiobuttons path="gender" items="${posibGender}" />
		</div>

		<button>Submit</button>
	</form:form>
</body>
</html>