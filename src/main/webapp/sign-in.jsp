<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<jsp:include page="part/header.jsp"/>


    <div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card border-0 shadow rounded-3 my-5">
                <div class="card-body p-4 p-sm-5">
                    <h5 class="card-title text-center mb-5 fw-light fs-5"><fmt:message key="sign.in"/> </h5>
                    <form method="POST" action="frontController">
                        <input type="hidden" name="action" value="sign-in">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="login" name="login"
                                   pattern="^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\d.-]{3,20}$" required>
                            <label for="login"><fmt:message key="login"/></label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="password" name="password"
                                   pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,20}$" required>
                            <label for="password"><fmt:message key="password"/></label>
                        </div>
                        <div class="d-grid">
                            <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit"><fmt:message key="sign.in"/></button>
                        </div>
                        <div class="text-center">
                        <p><fmt:message key="not.member"/> <a href="sign-up.jsp"><fmt:message key="sign.up"/></a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</form>

<jsp:include page="part/footer.jsp"/>

</body>

</html>