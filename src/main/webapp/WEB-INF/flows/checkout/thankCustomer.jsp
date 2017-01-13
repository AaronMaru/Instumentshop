<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/partials/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div>
                <div class="container">
                    <h1>Thank you for your business!</h1>
                    <p>Your order will be shipped in two businiess days!</p>
                </div>
            </div>
        </section>
        <section class="container">
            <p>
                <a href="<spring:url value="/" />" class="btn btn-default">OK</a>
            </p>
        </section>
    </div>
</div>
<%@include file="/WEB-INF/views/partials/footer.jsp"%>
