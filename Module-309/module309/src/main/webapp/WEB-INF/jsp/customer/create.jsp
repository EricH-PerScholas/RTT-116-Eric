<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Create Customer</h1>
        </div>
    </div>
</section>

<section class="bg-light2 pt-5 pb-5">
    <div class="container">

        <div class="mb-3 row justify-content-center">
            <label for="companyName" class="col-sm-2 col-form-label">Company Name</label>
            <div class="col-sm-10 col-lg-6">
                <input type="text" class="form-control" id="companyName" name="companyName" value="">
            </div>
        </div>

        <div class="mb-3 row justify-content-center">
            <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
            <div class="col-sm-10 col-lg-6">
                <input type="text" class="form-control" id="firstName" name="firstName" value="">
            </div>
        </div>

        <div class="mb-3 row justify-content-center">
            <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
            <div class="col-sm-10 col-lg-6">
                <input type="text" class="form-control" id="lastName" name="lastName" value="">
            </div>
        </div>

    </div>
</section>


<jsp:include page="../include/footer.jsp"/>