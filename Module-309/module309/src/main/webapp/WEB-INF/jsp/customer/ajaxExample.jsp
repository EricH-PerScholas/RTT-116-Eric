<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Ajax Example</h1>
        </div>
    </div>
</section>

<script>
    $( document ).ready(function() {
        $('#ajaxBtn').on('click', function() {
            console.log("ajax button clicked")

            let cid = $("#cid").val();
            console.log("customerId = " + cid);

            $.ajax({
                method: "GET",
                url: "/customer/ajaxCall",
                data: { customerId: cid }
            }).done(function( msg ) {
                console.log(msg)
                let customer = JSON.parse(msg);
                $('#ajaxResult').text(customer.customerName + " " + customer.id);
            });

            console.log("after json call but before .done")
        });
    });
</script>

<section class="bg-light2">
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-6">
                <input id="cid"/>
                <button id="ajaxBtn" class="btn btn-primary">Ajax Trigger</button>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div id="ajaxResult"></div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>