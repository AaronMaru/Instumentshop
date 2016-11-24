<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>


            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${ pageContext.request.contextPath }/admin/product/add" method="post" commandName="product" >
        	
        	<div class="form-group">
        		<label for="name">Name</label>
        		<form:input path="productname" id="name" class="form-control"/>
        	</div>
        	        	
        	<div class="form-group">
        		<label for="category">Category</label>
        		<label class="checkbox-inline">
        			<form:radiobutton path="productcategory" id="category" value="instrument"/>Instrument
        		</label>
        		<label class="checkbox-inline">
        			<form:radiobutton path="productcategory" id="category" value="record"/>Record
        		</label>
        		<label class="checkbox-inline">
        			<form:radiobutton path="productcategory" id="category" value="accessory"/>Accessory
        		</label>
        	</div>
        	
        	<div class="form-group">
        		<label for="decription">Description</label>
        		<form:textarea path="productdescription" id="description" class="form-control"/>
        	</div>
        	
        	<div class="form-group">
        		<label for="price">Price</label>
        		<form:input path="productprice" id="price" class="form-control"/>
        	</div> 
        	
        	<div class="form-group">
        		<label for="condition">Condition</label>
        		<label class="checkbox-inline">
        			<form:radiobutton path="productcondition" id="condition" value="new"/>New
        		</label>
        		<label class="checkbox-inline">
        			<form:radiobutton path="productcondition" id="condition" value="used"/>Used
        		</label>
        	</div>
        	
        	<div class="form-group">
        		<label for="category">Status</label>
        		<label class="checkbox-inline">
        			<form:radiobutton path="productstatus" id="status" value="active"/>Active
        		</label>
        		<label class="checkbox-inline">
        			<form:radiobutton path="productstatus" id="status" value="inactive"/>Inactive
        		</label>
        	</div>
        	
        	<div class="form-group">
        		<label for="unitInStock">Unit in Stock</label>
        		<form:input path="unitinstock" id="unitInStock" class="form-control"/>
        	</div> 
        	
        	<div class="form-group">
        		<label for="manufacturer">Manufacturer</label>
        		<form:input path="productmanufacturer" id="manufacturer" class="form-control"/>
        	</div> 
        	
        	<%-- <div class="form-group">
                <label class="control-label" for="productImage">Upload Picture</label>
                <form:input type="file" path="productimage"  id="productImage" class="form:input-large" />
            </div> --%>
            
        	<br>
        	
        	<input type="submit" value="submit" class="btn btn-default">
        	<a href="<c:url value="/admin/product"/>" class="btn btn-default">Cancel</a>
        </form:form>
        <br>
	</div>
</div>
<%@include file="/WEB-INF/views/partials/footer.jsp" %>
