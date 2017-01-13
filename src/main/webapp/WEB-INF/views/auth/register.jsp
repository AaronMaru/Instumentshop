<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>
            <p class="lead">Fill the below information below:</p>
        </div>
        <form:form action="${ pageContext.request.contextPath }/register" method="post" commandName="customer">
            <h3>Basic Info</h3>
            <div class="form-group">
                <label for="name">Name </label>
                <form:errors path="customerName" cssStyle="color:#ff0000"/>
                <form:input path="customerName" id="customerName" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">UserName </label>
                <span style="color: #ff0000">${usernameMsg}</span>
                <form:errors path="username" cssStyle="color:#ff0000"/>
                <form:input path="username" id="username" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Password </label><form:errors path="password" cssStyle="color:#ff0000"/>
                <form:input path="password" id="password" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Email </label>
                <span style="color: #ff0000">${emailMsg}</span>
                <form:errors path="customerEmail" cssStyle="color:#ff0000"/>
                <form:input path="customerEmail" id="customerEmail" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Phone </label>
                <form:input path="customerPhone" id="customerPhone" class="form-control" />
            </div>

            <br>

            <h3>Billing Address</h3>
            <div class="form-group">
                <label for="name">Street Name </label>
                <form:input path="billingAddress.streetName" id="billingStreet" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Apartment Number </label>
                <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">City </label>
                <form:input path="billingAddress.city" id="billingCity" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">State </label>
                <form:input path="billingAddress.state" id="billingState" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Country </label>
                <form:input path="billingAddress.country" id="billingCountry" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Zipcode </label>
                <form:input path="billingAddress.zipCode" id="billingZip" class="form-control" />
            </div>

            <br>

            <h3>Shipping Address</h3>
            <div class="form-group">
                <label for="name">Street Name </label>
                <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Apartment Number </label>
                <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">City </label>
                <form:input path="shippingAddress.city" id="shippingCity" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">State </label>
                <form:input path="shippingAddress.state" id="shippingState" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Country </label>
                <form:input path="shippingAddress.country" id="shippingCountry" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Zipcode </label>
                <form:input path="shippingAddress.zipCode" id="shippingZip" class="form-control" />
            </div>

            <br>

            <input type="submit" value="submit" class="btn btn-default">
            <a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>
        </form:form>
        <br>
    </div>
</div>
<%@include file="/WEB-INF/views/partials/footer.jsp" %>
