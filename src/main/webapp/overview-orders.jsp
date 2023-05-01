<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <style>
        .dropbtn {
            background-color: #0a53be;
            color: white;
            font-size: 16px;
            border: none;
            cursor: pointer;
            flex: 1
        }

        .dropdown {
            position: relative;
            display: inline-block;
            width: 33%; display: flex;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            flex: 1;
        }

        .dropdown-content a:hover {background-color: #f1f1f1}

        .dropdown:hover .dropdown-content {
            display: block;
            flex: 1;
            width: 40%;
        }

        .dropdown:hover .dropbtn {
            background-color: #0dcaf0;
        }
    </style>
</head>

<body>

<jsp:include page="part/header.jsp"/>
<div style="display: flex; background-color: white;margin-left: 10px;margin-right: 10px; margin-top: 5px;">

    <div class="dropdown">
        <button class="dropbtn">Sort by</button>
        <div class="dropdown-content">
            <c:forEach var="item" items="${ requestScope.sortByOptions }">
                <a class="dropdown-item ${requestScope.sortByField eq item ? 'link-danger' : ''}"
                   href="frontController?action=display-orders&currentPage=${requestScope.currentPage}&sortByField=${item}${not empty requestScope.clientFilter?'&clientFilter='.concat(requestScope.clientFilter):''}${not empty requestScope.dateFilter?'&dateFilter='.concat(requestScope.dateFilter):''}">${item}</a>
            </c:forEach>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Client filter</button>
        <div class="dropdown-content">
            <c:forEach var="item" items="${ requestScope.clientOptions }">
                <a class="dropdown-item ${requestScope.clientFilter eq item ? 'link-danger' : ''}"
                   href="frontController?action=display-orders&currentPage=${requestScope.currentPage}&clientFilter=${item}${not empty requestScope.sortByField?'&sortByField='.concat(requestScope.sortByField):''}${not empty requestScope.dateFilter?'&dateFilter='.concat(requestScope.dateFilter):''}">${item}</a>
            </c:forEach>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Date filter</button>
        <div class="dropdown-content">
            <c:forEach var="item" items="${ requestScope.dateOptions }">
                <a class="dropdown-item ${requestScope.sortByField eq item ? 'link-danger' : ''}"
                   href="frontController?action=display-orders&currentPage=${requestScope.currentPage}&dateFilter=${item}${not empty requestScope.sortByField?'&sortByField='.concat(requestScope.sortByField):''}${not empty requestScope.clientFilter?'&clientFilter='.concat(requestScope.clientFilter):''}">${item}</a>
            </c:forEach>
        </div>
    </div>

</div>

<div class="bd-example-snippet bd-code-snippet">
    <div class="bd-example">
        <table class="table table-striped" aria-label="report-table">
            <thead>
            <tr>
                <th><fmt:message key="order.id"/></th>
                <th><fmt:message key="departure.address"/></th>
                <th><fmt:message key="destination.address"/></th>
                <th><fmt:message key="distance"/></th>
                <th><fmt:message key="passengers.number"/></th>
                <th><fmt:message key="category"/></th>
                <th><fmt:message key="cost"/></th>
                <th><fmt:message key="client.login"/></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="order" items="${requestScope.orders}">
                <tr>
                    <td><c:out value="${order.id}"/></td>
                    <td><c:out value="${order.departureAddress}"/></td>
                    <td><c:out value="${order.destinationAddress}"/></td>
                    <td><c:out value="${order.distance}"/></td>
                    <td><c:out value="${order.numOfPassengers}"/></td>
                    <td><c:out value="${order.cabCategory.name}"/></td>
                    <td><c:out value="${order.cost}"/></td>
                    <td><c:out value="${order.client.login}"/></td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="part/pagination.jsp"/>
<jsp:include page="part/footer.jsp"/>
</body>
</html>