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

	<div id="box1" class="box">
		<div class="box-top">
			<h2>Get Training Schedule</h2>
		</div>
	</div>

	<div class="box-middle">
		<form method="post" action="getDetails">
			<div style="padding-left: 500px;">
				<input type="date" name="date" /> <input
					style="font-size: initial; font-family: initial; background-color: lavender; font-weight: bold;"
					type="submit" value="Get Training Schedule">
			</div>
			<input
				style="font-size: initial; font-family: initial; background-color: lavender; font-weight: bold; margin-left: 500px; margin-top: 20px; width: 200px;"
				value="Add more Training Records" onclick="window.location.href='/'">
				
			<input
				style="font-size: initial; font-family: initial; background-color: lavender; font-weight: bold; margin-left: 300px;margin-top: 50px;"
				value="Get Training Schedule"
				onclick="window.location.href='/getTrainingSchedule'">
		</form>
	</div>
	<div class="box-bottom"></div>
	</div>
	</div>




	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
