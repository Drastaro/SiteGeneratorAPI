<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="command"
		action="returnproduct">


		<div class="footer">
			<input type="text" name="q" value="${model.query}" />
			<button type="submit" value="Save" class="btn btn-block btn-primary">Submit</button>
		</div>
	</form:form>
</body>
</html>