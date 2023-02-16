<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/bootstrap.min.js"></script>
</head>

<body>

<jsp:include page="part/header.jsp"/>


<div class="dropdown">
    <button class="dropbtn">Sorting field</button>
    <div class="dropdown-content">
        <a href="#">Date</a>
        <a href="#">Price</a>


    </div>
</div>

    <div class="dropdown">
        <button class="dropbtn">Client filter</button>
        <div class="dropdown-content">
            <a href="#">BohdanZorii</a>
            <a href="#">user2</a>
            <a href="#">user3</a>
            <a href="#">user4</a>
            <a href="#">user5</a>
            <a href="#">user6</a>

        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Date filter</button>
        <div class="dropdown-content">
            <a href="#">2023-02-03</a>
            <a href="#">2023-01-19</a>
            <a href="#">2023-01-12</a>
            <a href="#">2023-01-27</a>
        </div>
    </div>

</div>


<div class="bd-example-snippet bd-code-snippet">
    <div class="bd-example">
        <table class="table table-striped" aria-label="report-table">
            <thead>
            <tr>
                <th>Стовпець 1</th>
                <th>Стовпець 2</th>
                <th>Стовпець 3</th>
                <th>Стовпець 4</th>
                <th>Стовпець 5</th>
                <th>Стовпець 6</th>
                <th>Стовпець 7</th>
                <th>Стовпець 8</th>
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
                    <td><c:out value="${order.cabCategory}"/></td>
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