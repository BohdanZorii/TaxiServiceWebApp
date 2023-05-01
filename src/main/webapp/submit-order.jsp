<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

</head>

<body>

<jsp:include page="part/header.jsp"/>


<div class="container">
  <div class="row">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
      <div class="card border-0 shadow rounded-3 my-5">
        <div class="card-body p-4 p-sm-5">


          <h1 class="card-title text-center mb-5 fw-light fs-5">
            <fmt:message key="order.info"/>      <a href="make-order.jsp">
            <i class="material-icons">edit</i>
          </a>
          </h1>

          <div class="row">
            <div class="col-md-6">
              <label><fmt:message key="departure.address"/></label>
            </div>
            <div class="col-md-6">
              <p>${sessionScope.order.departureAddress}</p>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <label><fmt:message key="destination.address"/></label>
            </div>
            <div class="col-md-6">
              <p>${sessionScope.order.destinationAddress}</p>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <label><fmt:message key="passengers.number"/></label>
            </div>
            <div class="col-md-6">
              <p>${sessionScope.order.numOfPassengers}</p>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <label><fmt:message key="category"/></label>
            </div>
            <div class="col-md-6">
              <p>${sessionScope.order.cabCategory.name}</p>
            </div>
            <div class="row">
              <div class="col-md-6">
                <label><fmt:message key="distance"/></label>
              </div>
              <div class="col-md-6">
                <p>${sessionScope.order.distance}</p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <label><fmt:message key="cost"/></label>
              </div>
              <div class="col-md-6">
                <p>${sessionScope.order.cost}</p>
              </div>
          </div>
              <div class="d-grid">
                <a href="frontController?action=make-order">
              <button class="btn btn-secondary btn-login text-uppercase fw-bold" type="button">
               <fmt:message key="submit.order"/>
              </button>
                </a>

            </div>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="part/footer.jsp"/>

</body>
</html>
