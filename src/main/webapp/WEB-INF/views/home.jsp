<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
	${simpleString.simpleString} </h1>
	<c:forEach var="list" items="${lists}">
		${list.name }
	</c:forEach>
</body>
</html>
