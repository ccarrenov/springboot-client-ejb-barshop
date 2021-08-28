<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<title>Country</title>
</head>
<body>

	<form:form id="frm-create" method="POST" action="/country/create"
		modelAttribute="country">
		<form:label id="lbl-id" path="id">ID:</form:label>
		<form:input id="txt-id" path="id" />
		<form:label id="lbl-name" path="name">NAME:</form:label>
		<form:input id="txt-name" path="name" />
		<form:label id="lbl-country-code" path="countryCode">COUNTRY CODE:</form:label>
		<form:input id="txt-country-code" path="countryCode" />
		<form:label id="lbl-two-digit-iso" path="twoDigitIso">TWO DIGIT ISO:</form:label>
		<form:input id="txt-two-digit-iso" path="twoDigitIso" />
		<form:label id="lbl-three-digit-iso" path="threeDigitIso">THREE DIGIT ISO:</form:label>
		<form:input id="txt-three-digit-iso" path="threeDigitIso" />
		<form:label id="lbl-country-calling-code" path="countryCallingCode">COUNTRY CALLING CODE:</form:label>
		<form:input id="txt-country-calling-code" path="countryCallingCode" />

		<input type="submit" value="Submit" />
	</form:form>

	<table id="tbl-countries">
		<caption>Table Countries</caption>
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">NAME</th>
				<th scope="col">COUNTRY CODE</th>
				<th scope="col">TWO DIGIT ISO</th>
				<th scope="col">THREE DIGIT ISO</th>
				<th scope="col">COUNTRY CALLING CODE</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${countries}" var="country">
				<tr>
					<td>${country.id}</td>
					<td>${country.name}</td>
					<td>${country.countryCode}</td>
					<td>${country.twoDigitIso}</td>
					<td>${country.threeDigitIso}</td>
					<td>${country.countryCallingCode}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>