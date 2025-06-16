<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<%@include file="../layouts/header.jsp" %>
<h1 class="page-header my-4"><i class="far fa-file-alt"></i> ${stock.stockName}</h1>
<hr>
<div class="card p-4 shadow-sm mt-3">

    <div><b>종목 코드: </b>${stock.stockCode}</div>
    <br>
    <div><b>현재가: </b><fmt:formatNumber value="${stock.price}" type="number" /></div>
    <br>
    <div>
        <b>등록일: </b><fmt:formatDate pattern="yyyy-MM-dd" value="${stock.regDate}"/>
    </div>
    <br>
    <div><b>설명: </b><br>
        ${stock.description}
    </div>
</div>

<div class="mt-4">
    <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
    <form action="mesu" method="post" class="d-inline">
        <input type="hidden" name="stockCode" value="${stock.stockCode}" />
        <input type="hidden" name="stockName" value="${stock.stockName}" />
        <input type="hidden" name="price" value="${stock.price}" />

        <button type="submit" class="btn btn-success">
            <i class="fa-solid fa-cart-shopping"></i> 매수하기
        </button>
    </form>
</div>

<script src="/resources/js/stock.js"></script>

<%@include file="../layouts/footer.jsp" %>