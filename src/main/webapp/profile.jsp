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
                        <fmt:message key="profile.info"/>        <a href="edit-profile.jsp">
                            <i class="material-icons">edit</i>
                        </a>
                    </h1>

                    <div class="row">
                        <div class="col-md-6">
                            <label><fmt:message key="first.name"/></label>
                        </div>
                        <div class="col-md-6">
                            <p>${sessionScope.currentUser.firstName}</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <label><fmt:message key="last.name"/></label>
                        </div>
                        <div class="col-md-6">
                            <p>${sessionScope.currentUser.lastName}</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <label><fmt:message key="email"/></label>
                        </div>
                        <div class="col-md-6">
                            <p>${sessionScope.currentUser.email}</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <label><fmt:message key="login"/></label>
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
