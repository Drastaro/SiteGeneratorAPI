<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="command"
		action="submitcomparerandom">


		<div class="footer">
			<form:select path="category">
				<label>Product Category</label>
				<form:option value="">Select Category</form:option>
				<form:option value="BLOOD_PRESSURE_MONITOR">BLOOD_PRESSURE_MONITOR</form:option>
				<form:option value="SPHYGMOMANOMETER">SPHYGMOMANOMETER</form:option>
			</form:select>
			<button type="submit" value="Save" class="btn btn-block btn-primary">Submit</button>

		</div>
	</form:form>
</body>
</html>