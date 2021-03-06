<%@include file="/WEB-INF/views/partials/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div id="login-box">
			<h2>Login with Username and Password</h2>

			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>


			<form name="loginForm"
				action="<c:url value="/j_spring_security_check" />" method="post">
				<c:if test="${not empty error}">
					<div class="error" style="color: #ff0000;">${error}</div>
				</c:if>

				<div class="form-group">
					<label for="username">User Name: </label> <input type="text"
						id="username" name="username" class="form-control" />
				</div>
				<div class="form-group">
					<label for="password">Passwrod:</label> <input type="password"
						id="password" name="password" class="form-control" />
				</div>
				<input type="submit" value="Submit" class="btn btn-default">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				
				<br>
				<br>
				<div class="etc-login-form">
					<!-- <p>forgot your password? <a href="#">click here</a></p> -->
					<p>new user? <a href="${ pageContext.request.contextPath }/register">Register</a></p>
				</div>
				
			</form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/partials/footer.jsp"%>