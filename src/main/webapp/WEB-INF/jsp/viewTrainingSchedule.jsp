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

	<div class="container">

		<div class="starter-template">
			<h2>Scheduled Training Details for Requested Date  </h2>
		<c:forEach var="training" items="${trainingDetails}">
		<br/>
	<table>
        <tr>
            <th>Trainer ID</th><th>Trainer Name</th> <th>College</th> <th>Training Name</th> <th>Duration</th> <th>Domain</th>
        </tr>
        <tr>
            <td>${training.trainerID}</td>
            <td>${training.trainerName}</td>
            <td>${training.collegeName} </td>
            <td>${training.trainingName}</td>
            <td>${training.duration}</td>
            <td>${training.domain}</td>
       
        </tr>
    </table>
    
		</c:forEach>
		</div>
		
		
		<a href="getTrainingSchedule">Get Training Schedule</a>

	</div>


	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
