<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<script src="js/bootstrap.bundle.min.js"></script>
<jsp:include page="part/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card border-0 shadow rounded-3 my-5">
                <div class="card-body p-4 p-sm-5">
                    <h1 class="card-title text-center mb-5 fw-light fs-5">Make order</h1>
                    <form method="POST" action="frontController">

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="departureAddr" name="departureAddr"
                                   value="${sessionScope.order.departureAddress}">
                            <label for="departureAddr">departureAddr</label>

                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="destinationAddr" name="destinationAddr"
                                   value="${sessionScope.order.destinationAddress}">
                            <label for="destinationAddr">destinationAddr</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" id="numOfPassengers" name="numOfPassengers"
                                   value="${sessionScope.order.numOfPassengers}">
                            <label for="numOfPassengers">number of passengers</label>
                        </div>


                        <select class="form-select" name="category" id="category">
                            <c:forEach var="item" items="${ sessionScope.categories }">
                                <c:choose>
                                    <c:when test="${sessionScope.order.cabCategory eq item.name}">
                                        <option selected="selected">
                                                ${item.name}
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>
                                                ${item.name}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                        <div>
                            <input type="hidden" name="action" value="calculate-price">
                            <div class="d-grid">
                                <button class="btn btn-secondary btn-login text-uppercase fw-bold" type="submit">
                                    CALCULATE PRICE
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="part/footer.jsp"/>

</body>
</html>