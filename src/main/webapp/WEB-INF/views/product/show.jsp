<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>


            <p class="lead">Here is the detail information of the product:</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${ product.productId }.png"/>" alt="image" style="width:100%"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.productname}</h3>
                    <p>${product.productdescription}</p>
                    <p><strong>Manufacturer</strong>: ${product.productmanufacturer}</p>
                    <p><strong>Category</strong>: ${product.productcategory}</p>
                    <p><strong>Condition</strong>: ${product.productcondition}</p>
                    <p>${product.productprice} USD</p>

                    <br/>

                </div>
            </div>
        </div>
	</div>
</div>
<script src="<c:url value="/resources/js/product.js"/>"></script>
<%@include file="/WEB-INF/views/partials/footer.jsp" %>
