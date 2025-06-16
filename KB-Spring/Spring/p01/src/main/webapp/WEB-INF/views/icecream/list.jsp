<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<h2>아이스크림 목록</h2>
<ul>
    <c:forEach var="ice" items="${list}">
        <li>
                ${ice.name} - ${ice.flavor}
            <form action="${pageContext.request.contextPath}/icecream/delete" method="post" style="display:inline;">
                <input type="hidden" name="no" value="${ice.no}" />
                <button type="submit">삭제</button>
            </form>
        </li>
    </c:forEach>
</ul>
