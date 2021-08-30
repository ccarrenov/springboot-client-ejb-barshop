<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<title>Country</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Country Maintainer</title>
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
</head>
<body>
	<div class="container-sm" style="margin: 0 auto;">
		<br />
		<h3>COUNTRY MAINTAINER</h3>
		<br />
		<form:form id="frm-create" method="POST" action="/country"
			modelAttribute="country">
			<div class="form-group">
				<form:label id="lbl-id" path="id">ID:</form:label>
				<form:input id="txt-id" path="id"
					cssClass="form-control form-control-lg" />
			</div>
			<div class="form-group">
				<form:label id="lbl-name" path="name">NAME:</form:label>
				<form:input id="txt-name" path="name"
					cssClass="form-control form-control-lg" />
			</div>
			<div class="form-group">
				<form:label id="lbl-country-code" path="countryCode">COUNTRY CODE:</form:label>
				<form:input id="txt-country-code" path="countryCode"
					cssClass="form-control form-control-lg" />
			</div>
			<div class="form-group">
				<form:label id="lbl-two-digit-iso" path="twoDigitIso">TWO DIGIT ISO:</form:label>
				<form:input id="txt-two-digit-iso" path="twoDigitIso"
					cssClass="form-control form-control-lg" />
			</div>
			<div class="form-group">
				<form:label id="lbl-three-digit-iso" path="threeDigitIso">THREE DIGIT ISO:</form:label>
				<form:input id="txt-three-digit-iso" path="threeDigitIso"
					cssClass="form-control form-control-lg" />
			</div>
			<div class="form-group">
				<form:label id="lbl-country-calling-code" path="countryCallingCode">COUNTRY CALLING CODE:</form:label>
				<form:input id="txt-country-calling-code" path="countryCallingCode"
					cssClass="form-control form-control-lg" />
			</div>
			<button id="btn-create" type="submit" class="btn btn-primary btn-lg">CREATE</button>
		</form:form>
		<br />
		<div class="table-responsive-lg">
			<table id="tbl-countries" class="table table-dark">
				<caption>Table Countries</caption>
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">ID</th>
						<th scope="col">NAME</th>
						<th scope="col">COUNTRY CODE</th>
						<th scope="col">TWO DIGIT ISO</th>
						<th scope="col">THREE DIGIT ISO</th>
						<th scope="col">COUNTRY CALLING CODE</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${countries}" var="country" varStatus="loop">
						<tr>
							<td>${loop.index}</td>
							<td>${country.id}</td>
							<td>${country.name}</td>
							<td>${country.countryCode}</td>
							<td>${country.twoDigitIso}</td>
							<td>${country.threeDigitIso}</td>
							<td>${country.countryCallingCode}</td>
							<td>UPDATE</td>
							<td>DELETE</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="js/jquery/jquery-3.5.1.min.js"></script>
	<script src="js/popper/popper.min.js"></script>
	<script src="js/bootstrap/bootstrap.min.js"></script>
</body>
</html>