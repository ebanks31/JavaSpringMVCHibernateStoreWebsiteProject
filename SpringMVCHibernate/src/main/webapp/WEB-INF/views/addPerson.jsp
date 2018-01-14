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
    <title>Person Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Person
</h1>

<c:url var="addAction" value="/person/add" ></c:url>

<form:form modelAttribute="personAttribute" method="post" action="${addAction}" >
<table>
    <!--<c:if test="${!empty person.firstName}"> -->
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td>
    </tr>
    <!--</c:if>-->
    <tr>
        <td>
            <form:label path="firstName">
                <spring:message text="First name"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstName" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="lastName">
                <spring:message text="Last name"/>
            </form:label>
        </td>
        <td>
            <form:input path="lastName" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="age">
                <spring:message text="Age"/>
            </form:label>
        </td>
        <td>
            <form:input path="age" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty person}">
                <input type="submit"
                    value="<spring:message text="Edit Person"/>" />
            </c:if>
            <c:if test="${empty person}">
                <input type="submit"
                    value="<spring:message text="Add Person"/>" />
            </c:if>
        </td>
    </tr>
</table>
</form:form>
</body>
</html>