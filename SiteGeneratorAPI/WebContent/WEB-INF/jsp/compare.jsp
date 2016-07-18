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
		action="submitcompare">


		<div class="footer">
			<div>
				<p>Product 1</p>
				<input type="text" name="p1" value="${model.p1}" />
			</div>
			<div>
				<p>Product 2</p>
				<input type="text" name="p2" value="${model.p2}" />
			</div>
			<div>
				<p>Product 3</p>
				<input type="text" name="p3" value="${model.p3}" />
			</div>
			<div>
				<p>Product 4</p>
				<input type="text" name="p4" value="${model.p4}" />
			</div>
			<div>
				<p>Product 5</p>
				<input type="text" name="p5" value="${model.p5}" />
			</div>
			<br>
			<button type="submit" value="Save" class="btn btn-block btn-primary">Submit</button>

		</div>
	</form:form>

</body>
</html>