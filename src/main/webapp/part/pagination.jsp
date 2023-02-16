<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="pagination justify-content-center">

    <c:choose>
        <c:when test="${empty requestScope.currentPage}">No orders yet</c:when>
        <c:otherwise>
            <c:forEach var="page" begin="${requestScope.startPage}" end="${requestScope.endPage}">
                <li class="page-item">
                    <a class="page-link ${requestScope.currentPage eq page ? 'dark-active' : 'link-dark'}"
                       href="frontController?action=display-orders&currentPage=${page}">
                            ${page}
                    </a>
                </li>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</ul>