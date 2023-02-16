<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 03.02.2023
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
            Order info        <a href="make-order.jsp">
            <i class="material-icons">edit</i>
          </a>
          </h1>

          <div class="row">
            <div class="col-md-6">
              <label>Departure address:</label>
            </div>
            <div class="col-md-6">
              <p>${sessionScope.order.departureAddress}</p>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <label>Destination address:</label>
            </div>
            <div class="col-md-6">
              <p>${sessionScope.order.destinationAddress}</p>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <label>Number of passengers:</label>
            </div>
            <div class="col-md-6">
              <p>${sessionScope.order.numOfPassengers}</p>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <label>Cab category:</label>
            </div>
            <div class="col-md-6">
              <p>${sessionScope.order.cabCategory}</p>
            </div>

            <div class="row">
              <div class="col-md-6">
                <label>Cost:</label>
              </div>
              <div class="col-md-6">
                <p>${sessionScope.order.cost}</p>
              </div>
          </div>
              <div class="d-grid">

              <button class="btn btn-secondary btn-login text-uppercase fw-bold" type="button">
                <a href="frontController?action=make-order">SUBMIT ORDER </a>
              </button>

            </div>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="part/footer.jsp"/>

</body>
</html>
