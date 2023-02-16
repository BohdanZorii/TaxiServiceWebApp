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
                        Profile info        <a href="edit-profile.jsp">
                            <i class="material-icons">edit</i>
                        </a>
                    </h1>

                    <div class="row">
                        <div class="col-md-6">
                            <label>First name:</label>
                        </div>
                        <div class="col-md-6">
                            <p>${sessionScope.currentUser.firstName}</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <label>Last name:</label>
                        </div>
                        <div class="col-md-6">
                            <p>${sessionScope.currentUser.lastName}</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <label>Email:</label>
                        </div>
                        <div class="col-md-6">
                            <p>${sessionScope.currentUser.email}</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <label>User name:</label>
                        </div>
                        <div class="col-md-6">
                            <p>${sessionScope.currentUser.login}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="part/footer.jsp"/>

</body>
</html>
