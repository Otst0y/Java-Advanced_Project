<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
	<title><spring:message code='login.title'/></title>



<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">


<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>
</head>

<body>
	<div class="container-fluid" >

	<!-- Sidebar -->
		<div class="w3-sidebar" style="width: 10%">

			<div class="list-group" style="margin-top: 40px">

				<div class="list-group-item active">
					<div>
						<h3><spring:message code='login.title'/></h3>
					</div>
					<div>${pageContext.request.userPrincipal.name}</div>
				</div>

				<a href="/home" class="list-group-item"> <i
					class="fa fa-comment-o"></i> <spring:message code='sidebar.home'/>
				</a>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="/create-periodical" class="list-group-item"> <i
						class="fa fa-search"></i><spring:message code='sidebar.create_periodical'/>
					</a>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_USER')">
					<a href="/buckets" class="list-group-item"> <i
						class="fa fa-search"></i> <spring:message code='sidebar.bucket'/>
					</a>
				</security:authorize>


				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<a class="list-group-item"
						onclick="document.forms['logoutForm'].submit()"
						style="cursor: pointer"> <i class="fa fa-search"></i>  <spring:message code='sidebar.logout'/>
					</a>

				</c:if>

			</div>
		</div>


		<!-- Page Content -->
		<div style="margin-left: 10%">

			<div class="w3-container">

				<c:if test="${not empty periodicals}">
					<c:forEach items="${periodicals}" var="currentPeriodical">

						<div class="w3-card-4" style="width: 20%; margin: 2%; float:left">
							<img
								src="data:image/jpg;base64, ${currentPeriodical.encodedImage}"
								alt="Norway" style="width: 100%">
							<div class="w3-container w3-center">
								<h3>${currentPeriodical.name}</h3>
								<p>${currentPeriodical.description}</p>
								<p>${currentPeriodical.price}</p>
							</div>

							<security:authorize access="hasRole('ROLE_USER')">

								<form:form action="${contextPath}/bucket" method="POST"
									enctype="multipart/form-data">
									<input type="hidden" value="${currentPeriodical.id}"
										class="form-control" name="periodicalId">
									<input type="submit" class="w3-button w3-block w3-dark-grey"
										value="+ <spring:message code='bucket.add'/>">
								</form:form>
							</security:authorize>

						</div>

					</c:forEach>
				</c:if>
			</div>

		</div>


	</div>
</body>
</html>