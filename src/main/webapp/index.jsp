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
    <style>
        img {
            display: block;
            margin-left: auto;
            margin-right: auto;
            vertical-align: center;
        }

        .container {
            display: flex;
            align-items: center;
            justify-content: center;
            color: green;
        }
    </style>
</head>
<body>

<jsp:include page="part/header.jsp"/>


<div class="container">
    <img src="img/london-black-cabs_monopoly.jpg" width="700" alt="asc">


    <form method="POST" action="frontController">
        <c:choose>
            <c:when test="${empty sessionScope.currentUser}">
                <a href="sign-in.jsp">
                    <button type="button" class="btn btn-primary" style="background-color: #009933;">
                        <h3><fmt:message key="login"/> </h3>
                    </button>
                </a>
            </c:when>
            <c:when test="${sessionScope.currentUser.role eq 'CLIENT'}">
                <input type="hidden" name="action" value="prepare-categories">
                <button type="submit" class="btn btn-primary" style="background-color: #06357a;">
                    <h3>Make order</h3>
                </button>
            </c:when>
            <c:when test="${sessionScope.currentUser.role eq 'ADMIN'}">
                <a href="frontController?action=display-orders">
                <button type="button" class="btn btn-primary" style="background-color: #06357a;">
                        <h3>Overview orders</h3>
                </button>
                </a>
            </c:when>
        </c:choose>
    </form>
</div>


<jsp:include page="part/footer.jsp"/>


</body>
</html>
