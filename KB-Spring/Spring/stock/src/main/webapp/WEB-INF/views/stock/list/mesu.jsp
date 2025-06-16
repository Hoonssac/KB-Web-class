<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<%@include file="../../layouts/header.jsp"%>
<h1 class="page-header my-4"><i class="fa-solid fa-arrow-trend-up"></i> 매수한 주식 목록</h1>
<table class="table table-hover">
  <thead>
  <tr>
    <th>종목 코드</th>
    <th style="width: 100px">종목 이름</th>
    <th style="width: 130px">현재가</th>
    <th style="width: 130px">등록일</th>
    <th style="width: 80px">매도</th>
  </tr>
  </thead>
  <body>
  <c:forEach var="stock" items="${list}">
    <tr>
      <td>
          ${stock.stockCode}
      </td>
      <td>
        <a href="get?no=${stock.no}">${stock.stockName}</td>
      <td>
          ${stock.price}
      </td>
      <td>
        <fmt:formatDate pattern="yyyy-MM-dd" value="${stock.regDate}"/>
      </td>
      <td>
        <form action="/stock/mesu/delete" method="post" style="display:inline;">
          <input type="hidden" name="no" value="${stock.no}" />
          <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('정말 매도하시겠습니까?')">
            <i class="fas fa-trash-alt"></i> 매도
          </button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </body>
</table>
<%@include file="../../layouts/footer.jsp"%>