<%@include file="/WEB-INF/views/partials/header.jsp" %>
<div class="container-wrapper">
        <div class="container">
            <div class="page-header">
                <h1>All Product</h1>
                <p class="lead">Checkout all the products available!</p>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr class="bg-success">
                        <td>Photo Thumb</td>
                        <td>Product Name</td>
                        <td>Category</td>
                        <td>Condition</td>
                        <td>Price</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ products }" var="product">
                        <tr>
                            <td><img src="<c:url value="/resources/images/${ product.productId}.png"/>" alt="image" style="width:100%; height: 130px"/></td>
                            <td>${ product.productName }</td>
                            <td>${ product.productCategory }</td>
                            <td>${ product.productCondition }</td>
                            <td>${ product.productPrice }</td>
                            <td>
                            	<a href="<c:url value="/admin/product/${ product.productId }" />"><span class="glyphicon glyphicon-info-sign"></span></a>
                                <a href="<c:url value="/admin/product/${ product.productId }/edit" />"><span class="glyphicon glyphicon-pencil"></span></a>
                                <a href="<c:url value="/admin/product/${ product.productId }/delete" />"><span class="glyphicon glyphicon-remove"></span></a>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <a href="<c:url value="/admin/product/create"/>" class="btn btn-primary">Add Product</a>
	</div>          
 </div>
            <!-- FOOTER -->
            <%@include file="/WEB-INF/views/partials/footer.jsp" %>


