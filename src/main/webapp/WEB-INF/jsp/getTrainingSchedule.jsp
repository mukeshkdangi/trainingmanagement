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
			<div>
			<input type="date" name="date" />
				<input
					style="margin-left: 700px; font-size: initial; font-family: initial; background-color: lavender; font-weight: bold;"
					type="submit" value="Get Training Schedule">
			</div>
		</form>
	</div>
	<a href="/">Insert new Training Details</a>
	<div class="box-bottom"></div>
	</div></div>




	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
