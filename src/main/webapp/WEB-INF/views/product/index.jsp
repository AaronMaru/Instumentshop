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
                            <td><img src="<c:url value="/resources/images/${ product.productId }.png"/>" alt="image" style="width:100%"/></td>
                            <td>${ product.productname }</td>
                            <td>${ product.productcategory }</td>
                            <td>${ product.productcondition }</td>
                            <td>${ product.productprice }</td>
                            <td><a href="<c:url value="/product/${ product.productId }" />"><span class="glyphicon glyphicon-info-sign"></span></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </div>
</div>
            <!-- FOOTER -->
            <%@include file="/WEB-INF/views/partials/footer.jsp" %>


