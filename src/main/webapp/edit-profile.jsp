<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                    <h1 class="card-title text-center mb-5 fw-light fs-5">Edit profile</h1>
                    <form method="POST" action="frontController">
                        <input type="hidden" name="action" value="edit-profile">

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="firstName" name="firstName" value="${sessionScope.currentUser.firstName}"
                                   pattern="^[A-Za-zА-ЩЬЮЯҐІЇЄа-щьюяґіїє'\-]{1,20}" required>
                            <label for="firstName" >First name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="lastName" name="lastName" value="${sessionScope.currentUser.lastName}"
                                   pattern="^[A-Za-zА-ЩЬЮЯҐІЇЄа-щьюяґіїє'\-]{1,20}" required>
                            <label for="lastName">Last name</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="email" class="form-control" id="floatingEmail" name="email" value="${sessionScope.currentUser.email}"
                                   pattern="^[\w.%+-]+@[\w.-]+\.[a-zA-Z]{2,6}$" required>
                            <label for="floatingEmail">Email</label>
                        </div>

                        <div class="d-grid">
                            <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">Save changes</button>
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