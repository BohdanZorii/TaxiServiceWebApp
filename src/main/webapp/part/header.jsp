<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>
<html lang="${sessionScope.locale}">
<head>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Express Taxi</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="index.jsp">
                    <fmt:message key="home"/> </a></li>
                <li class="nav-item"><a class="nav-link" href="about-us.jsp">
                    <fmt:message key="about"/> </a></li>
                <li class="nav-item"><a class="nav-link" href="contact.jsp">
                    <fmt:message key="contact"/></a></li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

                <form method="POST" class="d-flex mt-1" >
                    <label>
                        <select name="locale" onchange='submit();'>
                            <option value="en" ${sessionScope.locale eq 'en' ? 'selected' : ''}>
                                <fmt:message key="en"/>
                            </option>
                            <option value="uk_UA" ${sessionScope.locale eq 'uk_UA' ? 'selected' : ''}>
                                <fmt:message key="ua"/>
                            </option>
                        </select>
                    </label>
                </form>

                <c:choose>
                    <c:when test="${not empty sessionScope.currentUser}">
                        <li class="nav-item"><a class="nav-link" href="profile.jsp"><i
                                class="material-icons">computer</i></a></li>
                        <li class="nav-item"><a class="nav-link" href="frontController?action=log-out"><i
                                class="material-icons">logout</i></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="sign-in.jsp"><i class="material-icons">login</i></a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>

        </div>

    </div>
</nav>
</body>
</html>



