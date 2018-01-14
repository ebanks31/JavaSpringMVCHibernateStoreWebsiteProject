<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>

<P> The time on the server is ${serverTime}. </P>
<a href="/SpringMVCHibernate/persons">List of people</a>
<a href="/SpringMVCHibernate/products">List of products</a>
<a href="/SpringMVCHibernate/categories">List of categories</a>
<a href="/SpringMVCHibernate/about">About</a>
</body>
</html>
