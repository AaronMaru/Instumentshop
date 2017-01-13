<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>
            <p class="lead">Customer Details</p>
        </div>
        <form:form commandName="order" class="form-horizontal">
            <h3>Shipping Address</h3>
            <div class="form-group">
                <label for="name">Street Name </label>
                <form:input path="cart.customer.shippingAddress.streetName" id="shippingStreet" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Apartment Number </label>
                <form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">City </label>
                <form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">State </label>
                <form:input path="cart.customer.shippingAddress.state" id="shippingState" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Country </label>
                <form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">Zipcode </label>
                <form:input path="cart.customer.shippingAddress.zipCode" id="shippingZip" class="form-control" />
            </div>

            <input type="hidden" name="_flowExecutionKey" />

            <br><br>
            <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
            <input type="submit" name="_eventId_shippingDetailCollected" value="Next" class="btn btn-default" />
            <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>
        <br>
    </div>
</div>
<%@include file="/WEB-INF/views/partials/footer.jsp" %>
