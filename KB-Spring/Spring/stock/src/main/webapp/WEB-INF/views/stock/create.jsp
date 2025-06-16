<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp"%>
<h1 class="page-header my-4"><i class="far fa-edit"></i> 새 종목 추가</h1>
<div >
    <form method="post" enctype="multipart/form-data">

        <div>
            <label>종목 코드</label>
            <input name="stockCode" class="form-control">
        </div>

        <div>
            <label>종목 이름</label>
            <input name="stockName" class="form-control">
        </div>

        <div>
            <label>현재가</label>
            <input class="form-control" name="price">
        </div>

        <div>
            <label>설명</label>
            <textarea class="form-control" name="description" rows="10"></textarea>
        </div>

        <div class="mt-4">
            <button type="submit" class="btn btn-primary"><i class="fas fa-check"></i> 확인</button>
            <button type="reset" class="btn btn-primary"><i class="fas fa-undo"></i> 취소</button>
            <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
        </div>

    </form>
</div>
<%@include file="../layouts/footer.jsp"%>
