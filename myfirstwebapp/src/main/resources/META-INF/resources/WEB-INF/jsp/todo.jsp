<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<link href="webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet"></link>
<link
	href="webjars/bootstrap-datepicker/2.4.4/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">
<title>Todo Page</title>
</head>
<body>
	<div class="container">
		<h1>Enter Todo details</h1>
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors type="text" path="description" cssClass="text-warning"
					required="required" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors type="text" path="targetDate" cssClass="text-warning"
					required="required" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />

			<input type="submit" class="btn btn-success" />
		</form:form>
	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.6.4/jquery.min.js"></script>
	<script
		src="webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
		</body>
		</html>
	