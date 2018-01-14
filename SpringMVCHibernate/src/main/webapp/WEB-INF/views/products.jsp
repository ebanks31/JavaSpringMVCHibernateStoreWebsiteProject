<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>
	<title>Product List</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Product List
</h1>

<br>
<h3>Product List</h3>
<c:if test="${!empty listProducts}">
    <table class="tg">
    <tr>
        <th width="80">Product ID</th>
        <th width="120">Product Name</th>
        <th width="120">Product Brand</th>
        <th width="120">Product Weight</th>
        <th width="120">Product Length</th>
        <th width="120">Product Cost</th>
        <th width="120">Person's Email</th>
        <th width="60">Add to Cart</th>
        <th width="60">Add to WishList</th>
    </tr>
    <c:forEach items="${listPerson}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.brand}</td>
            <td>${product.weight}</td>
            <td>${product.length}</td>
            <td>${product.cost}</td>
            <td><a href="<c:url value='/orders/add/${product.id}' />" >Add to Cart</a></td>
            <td><a href="<c:url value='/wishlist/add/${product.id}' />" >Add to WishList</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<c:url var="addUrl" value="/persons/add" />

<c:if test="${empty listProducts}">
 There are currently no persons in the list. <a href="${addUrl}">Add</a> a person.
</c:if>
<a href="<c:url value='/person/add' />" class="btn btn-info" role="button">Add Person</a>

</body>
</html>
