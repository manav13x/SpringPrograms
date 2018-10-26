<html>
<head>
<title>Book Page:</title>
</head>
<body>
<h1>Books:</h1>
	<table>
	<tr>
		<td><strong>Book Code</strong>	</td>
		<!-- even though principal is private in the model but this expression languag converts the below lineinto a getter method that's 
		why we can access a private data memeber -->
		<td><em>${book.bcode }</em></td>
		</tr>
		<tr>
		<td><strong>Title</strong>	</td>
		<td><em>${book.title }</em></td>
		</tr>
		<tr>
		<td><strong>Category</strong>	</td>
		<td><em>${book.category }</em></td>
		</tr>
		<tr>
		<td><strong>Price</strong>	</td>
		<td><em>${book.price }</em></td>
		</tr>
		<tr>
		<td><strong>Type</strong>	</td>
		<td><em>${book.type }</em></td>
		</tr>
	
	</table>
	
</body>
</html>