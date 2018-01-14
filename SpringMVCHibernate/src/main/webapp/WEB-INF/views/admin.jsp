<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>
	<title>Admin Page</title>
</head>
<body>
<h1>
	This is the admin page.
</h1>
<a href="http://localhost:8080/SpringMVCHibernate/products">Products</a>
<a href="http://localhost:8080/SpringMVCHibernate/orders" class="btn btn-info" role="button">Orders</a>
<a href="http://localhost:8080/SpringMVCHibernate/listUsers">Users</a>
<a href="http://localhost:8080/SpringMVCHibernate/metrics">Metrics</a>
</body>
</html>
