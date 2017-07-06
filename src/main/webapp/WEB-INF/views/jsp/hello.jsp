<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Spring 3 MVC Project</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">

		<h1>${title}</h1>
		<p>
			<c:if test="${not empty name}">
			Hello ${name}
		</c:if>

			<c:if test="${empty name}">
			Welcome Welcome!
		</c:if>
		</p>
		<p>
			<a class="btn btn-primary btn-lg" href="#" role="button">Learn
				more</a>
		</p>
	</div>
</div>

<div class="container">
	<c:if test="${not empty errorMesg}">
		<ul>
			<c:forEach items="${errorMesg}" var="mesg">
				<li class="alert-danger">${errorMesg }</li>
			</c:forEach>
		</ul>
	</c:if>
	<div class="row">
		<div class="col-md-4">
			<h2>User Details</h2>
			<p>
				<a class="btn btn-default" href="getUserDetails" role="button">Click
					here for user details</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Heading</h2>
			<p>ABC</p>
			<p>
				<a class="btn btn-default" href="showUserDetails" role="button">Show
					details</a>
			</p>
		</div>
		<div class="col-md-4">
			<form method="post" action="saveUserDetails">
				<p>
					First Name: <input type="text" name="firstName">
				</p>
				<p>
					Last Name: <input type="text" name="lastName">
				</p>
				<p>
					User Id: <input type="text" name="userId">
				</p>
				<p>
					Date of Birth: <input type="text" placeholder="dd-MM-yyyy" name="dob">
				</p>
				<p>
					<button class="btn btn-default" role="submit">Submit</button>
				</p>
			</form>

		</div>
	</div>


	<hr>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>