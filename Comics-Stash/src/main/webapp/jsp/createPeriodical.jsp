<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Periodicals</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="style/css/createPeriodical.css">
<title><spring:message code='login.title' /></title>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">

</head>
<body>
<body>
	<div class="container">

		<div class="w3-sidebar" style="width: 10%">

        			<div class="list-group" style="margin-top: 40px">

        				<div class="list-group-item active">
        					<div>
        						<h3>
        							<spring:message code='login.title' />
        						</h3>
        					</div>
        					<div>${pageContext.request.userPrincipal.name}</div>
        				</div>

        				<a href="/home" class="list-group-item"> <i
        					class="fa fa-comment-o"></i> <spring:message code='sidebar.home' />
        				</a>

        				<security:authorize access="hasRole('ROLE_ADMIN')">
        					<a href="/create-periodical" class="list-group-item"> <i
        						class="fa fa-search"></i>
        					<spring:message code='sidebar.create_periodical' />
        					</a>
        				</security:authorize>

        				<security:authorize access="hasRole('ROLE_USER')">
        					<a href="/buckets" class="list-group-item"> <i
        						class="fa fa-search"></i> <spring:message code='sidebar.bucket' />
        					</a>
        				</security:authorize>


        				<c:if test="${pageContext.request.userPrincipal.name != null}">
        					<form id="logoutForm" method="POST" action="${contextPath}/logout">
        						<input type="hidden" name="${_csrf.parameterName}"
        							value="${_csrf.token}" />
        					</form>

        					<a class="list-group-item"
        						onclick="document.forms['logoutForm'].submit()"
        						style="cursor: pointer"> <i class="fa fa-search"></i> <spring:message
        							code='sidebar.logout' />
        					</a>

        				</c:if>

        			</div>
        		</div>

		<!-- Page Content -->
		<div style="margin-left: 10%">
          <div class="w3-container" style="margin: 20%">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
              <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}"
                  value="${_csrf.token}" />
              </form>
            </c:if>

            <form:form method="POST" action="${contextPath}/addPeriodical"
              enctype="multipart/form-data" class="my-form">
              <table>
                <tr>
                  <td><label for="name">Name:</label></td>
                  <td><input type="text" name="name" id="name" /></td>
                </tr>
                <tr>
                  <td><label for="description">Description:</label></td>
                  <td><input type="text" name="description" id="description" /></td>
                </tr>
                <tr>
                  <td><label for="price">Price:</label></td>
                  <td><input type="number" name="price" id="price" /></td>
                </tr>
                <tr>
                  <td><label for="image">Select an image to upload:</label></td>
                  <td><input type="file" name="image" id="image" /></td>
                </tr>
                <tr>
                  <td colspan="2"><input type="submit" value="Submit" class="submit-btn" /></td>
                </tr>
              </table>
              <input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />
            </form:form>
          </div>
        </div>

	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>