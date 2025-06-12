<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>아이스크림 등록</h2>

<form action="${pageContext.request.contextPath}/icecream/new" method="post">
  이름: <input type="text" name="name" required><br>
  맛: <input type="text" name="flavor" required><br>
  가격: <input type="number" name="price" required><br>
  <button type="submit">등록</button>
</form>