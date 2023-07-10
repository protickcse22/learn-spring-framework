<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>List todos Page</title>
</head>
<body>
	<div>Welcome to ${name}</div>
	<hr>
	<h1>Your Todos are</h1>
	<table>
		<thead>

			<tr>
				<th>id</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
				</tr>

			</c:forEach>


		</tbody>

	</table>
</body>
</html>