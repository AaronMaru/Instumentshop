<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/partials/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<section>
			<div>
				<div class="container">
					<h1>Cart</h1>
					<p>All the selected products in your shopping cart</p>	
				</div>
			</div>
		</section>
		<section class="container">
			<div>
				<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
			</div>
			<table class="table table-hover">
				<tr>
					<td>Product</td>
					<td>Unit Price</td>
					<td>Quantity</td>
					<td>Price</td>
					<td>Action</td>
				</tr>
				<tr>
					<td>productName</td>
					<td>Product Price</td>
					<td>Quantity</td>
					<td>Total Price</td>
					<td>remove button</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>grandTotal</th>
					<th></th>
				</tr>				
			</table>
			
			<a href="<sping:url value="/product" />">Continue Shopping</a>
			
		</section>
	</div>
</div>

<%@include file="/WEB-INF/views/partials/footer.jsp"%>