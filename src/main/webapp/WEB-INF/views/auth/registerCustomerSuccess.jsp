<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/partials/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<section>
			<div>
				<div class="container">
					<h1>Customer Registerd Successfully!</h1>
				</div>
			</div>
		</section>
		<section class="container">
			<p>			
				<a href="<spring:url value="/product" />" class="btn btn-default">Products</a>
			</p>
		</section>
	</div>
</div>
<%@include file="/WEB-INF/views/partials/footer.jsp"%>
