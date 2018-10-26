<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Book Form Page</title>
</head>

<body>
	<h1>Book Form</h1>

	<!-- whoever accesses this page must send a default modelattribute to this SPRING FORM -->
	<form:form action="book" modelAttribute="book2" method="POST">
		<div>
			<!-- path refers to the property of the object received -->
			<form:label path="bcode">Book Code:</form:label>
			<form:input path="bcode" type="number" />
		</div>
		<div>
			<form:label path="title">Book Title:</form:label>
			<form:input path="title" type="text" />
		</div>
		<div>
			<form:label path="price">Book Price:</form:label>
			<form:input path="price" type="number" />
		</div>
		<div>
			<form:label path="category">Category:</form:label>
			<form:select path="category">
				<form:option value="">--SELECT--</form:option>
				<form:options items="${posibCategories }"/>
			</form:select>
		</div>
		<div>
			<form:label path="bcode">Book Type:</form:label>
			<form:radiobuttons path="type" items="${posibTypes}"/>
		</div>
		
		<div>
		<form:button type="submit">Save</form:button>
		</div>
	</form:form>
</body>
</html>