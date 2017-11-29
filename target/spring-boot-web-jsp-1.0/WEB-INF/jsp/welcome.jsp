<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<table border="1">
		<tr>
			<th>
				<div id="box1" class="box">
					<div class="box-top">
						<h2>Schedule Training</h2>
					</div>
				</div>
			</th>
		</tr>
		<tr>
			<td>
				<div class="box-middle">
					<form method="post" action="saveDetails"
						modelAttribute="trainingRecord">
						Trainer ID : <input type="text" name="trainerID" /> Trainer Name:
						<input type="text" name="trainerName"> <select id="domain"
							name="domain">
							<option value="JAVA">Java</option>
							<option value="DOTNET">.Net</option>
							<option value="PYTHON">Python</option>
							<option value="Others">Others</option>
						</select>

						<td>
						<tr>
	</table>
	<table border="1" stype="margin-top: 100px;">
		<tr>
			<th>
				<div id="box1" class="box">
					<div class="box-top">
						<h2>Training Details</h2>
					</div>
				</div>
			<td>
		<tr>
	</table>
	<table border="1">
		<tr>
			<th>SL NO.</th>
			<th>College Name</th>
			<th>Training Name</th>
			<th>Start Date</th>
			<th>Duration in Mins</th>
		</tr>
		<tr>
			<td>1.</td>
			<td><input type="text" name="collegeName" /></td>
			<td><input type="text" name="trainingName" /></td>
			<td><input type="date" name="date" /></td>
			<td><select id="duration" name="duration">
					<option value="60">60</option>
					<option selected="selected" value="120">120</option>
					<option value="180">180</option>
					<option value="240">240</option>
			</select></td>
		</tr>
	</table>
	<div>
		<input
			style="margin-left: 700px; width: 100px; font-size: initial; font-family: initial; background-color: lavender; font-weight: bold;"
			type="submit" value="SUBMIT">
	</div>
	<input
		style="font-size: initial; font-family: initial; background-color: lavender; font-weight: bold; margin-left: 400px;"
		value="Get Training Schedule"
		onclick="window.location.href='getTrainingSchedule'">
	</div>
	</form>
	</div>

	<div class="box-bottom"></div>
	</div>




	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
