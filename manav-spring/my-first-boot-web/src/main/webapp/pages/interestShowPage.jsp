<html>
<head>
<title>Loan Page:</title>
</head>
<body>
<h1>Loans:</h1>
	<table>
	<tr>
		<td><strong>Principal</strong>	</td>
		<!-- even though principal is private in the model but this expression languag converts the below lineinto a getter method that's 
		why we can access a private data memeber -->
		<td><em>${interest.principal }</em></td>
		</tr>
		<tr>
		<td><strong>Rate of Interest</strong>	</td>
		<td><em>${interest.rateOfInterest }</em></td>
		</tr>
		<tr>
		<td><strong>Time Period</strong>	</td>
		<td><em>${interest.timePeriod}</em></td>
		</tr>
		<tr>
		<td><strong>Simple Interest</strong>	</td>
		<td><em>${interest.simpleInterest }</em></td>
		</tr>
		<tr>
		<td><strong>Amount to be repaid</strong>	</td>
		<td><em>${interest.repayableAmount }</em></td>
		</tr>
	
	</table>
	
</body>
</html>