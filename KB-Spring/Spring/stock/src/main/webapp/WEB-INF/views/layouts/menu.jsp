<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-primary navbar-dark sticky-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="/stock/list"><i class="fa-solid fa-house"></i> 홈</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <!-- 좌측 메뉴 구성 -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#"><i class="fa-solid fa-arrow-trend-up"></i> 주식 목록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/stock/list/mesu"><i class="fa-solid fa-book"></i> 메수한 종목 보기</a>
        </li>
      </ul>
      <!-- 우측 메뉴 -->
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">
            <img src="/resources/images/profile.jpg"
                 class="avatar-sm"/>
            admin
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <i class="fa-solid fa-right-from-bracket"></i> 로그아웃
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>