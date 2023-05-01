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
          <h5 class="card-title text-center mb-5 fw-light fs-5"><fmt:message key="sign.up"/> </h5>

          <form method="POST" action="frontController">
            <input type="hidden" name="action" value="sign-up">

            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="firstName" name="firstName"
              pattern="^[A-Za-zА-ЩЬЮЯҐІЇЄа-щьюяґіїє'\-]{1,20}" required>
              <label for="firstName"><fmt:message key="first.name"/></label>
            </div>

            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="lastName" name="lastName"
                     pattern="^[A-Za-zА-ЩЬЮЯҐІЇЄа-щьюяґіїє'\-]{1,20}" required>
              <label for="lastName"><fmt:message key="last.name"/></label>
            </div>

            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="login" name="login"
              pattern="^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\d.-]{3,20}$" required>
              <label for="login"><fmt:message key="login"/></label>
            </div>

            <div class="form-floating mb-3">
              <input type="email" class="form-control" id="email" name="email"
              pattern="^[\w.%+-]+@[\w.-]+\.[a-zA-Z]{2,6}$" required>
              <label for="email"><fmt:message key="email"/></label>
            </div>

            <div class="form-floating mb-3">
              <input type="password" class="form-control" id="password" name="password"
              pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,20}$" required>
              <label for="password"><fmt:message key="password"/></label>
            </div>

            <div class="form-floating mb-3">
              <input type="password" class="form-control" id="repeatedPassword" name="repeatedPassword"
                     pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,20}$" required>
              <label for="repeatedPassword"><fmt:message key="repeat.password"/></label>

            </div>

            <div class="d-grid">
              <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit"><fmt:message key="sign.up"/> </button>
            </div>
            <div class="text-center">
              <p><fmt:message key="already.member"/> <a href="sign-in.jsp"><fmt:message key="sign.in"/></a></p>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="part/footer.jsp"/>

</body>
</html>