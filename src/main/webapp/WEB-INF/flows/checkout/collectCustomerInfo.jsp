<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>
            <p class="lead">Customer Details</p>
        </div>
        <form:form commandName="order" class="form-horizontal">
            <h3>Basic Info</h3>
            <div class="form-group">
                <label for="name">Name </label>
                <form:input path="cart.customer.customerName" id="customerName" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Email </label>
                <form:input path="cart.customer.customerEmail" id="customerEmail" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Phone </label>
                <form:input path="cart.customer.customerPhone" id="customerPhone" class="form-control" />
            </div>

            <br>

            <h3>Billing Address</h3>
            <div class="form-group">
                <label for="name">Street Name </label>
                <form:input path="cart.customer.billingAddress.streetName" id="billingStreet" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Apartment Number </label>
                <form:input path="cart.customer.billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">City </label>
                <form:input path="cart.customer.billingAddress.city" id="billingCity" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">State </label>
                <form:input path="cart.customer.billingAddress.state" id="billingState" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Country </label>
                <form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Zipcode </label>
                <form:input path="cart.customer.billingAddress.zipCode" id="billingZip" class="form-control" />
            </div>

            <input type="hidden" name="_flowExecutionKey" />

            <br><br>

            <input type="submit" name="_eventId_customerInfoCollected" value="Next" class="btn btn-default" />
            <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>
        <br>
    </div>
</div>
<%@include file="/WEB-INF/views/partials/footer.jsp" %>
