<%@include file="/WEB-INF/views/partials/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Customer Management Page</h1>
			<p class="lead">This is the customer management page!</p>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<td>Name</td>
					<td>Email</td>
					<td>Phone</td>
					<td>Username</td>
					<td>Enabled</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ customers }" var="customer">
					<tr>

						<td>${ customer.customerName }</td>
						<td>${ customer.customerEmail }</td>
						<td>${ customer.customerPhone }</td>
						<td>${ customer.username }</td>
						<td>${ customer.enabled }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<!-- FOOTER -->
<%@include file="/WEB-INF/views/partials/footer.jsp"%>


