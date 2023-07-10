<html>
<head>
<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet"></link>
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to the login page!</h1>
		<pre>${errorMsg}</pre>
		<form method="post">
			Name: <input type="text" name="name"> Password: <input
				type="password" name="password"> <input type="submit"
				class="btn btn-primary">
		</form>
	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>