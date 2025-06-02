<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<body>
<h1>getParameter 실습</h1>
<%--action에 넘긴 경로가 servlet과 연결된다--%>
<form action="login" method="post">
    <fieldset>
        <legend>로그인 폼</legend>
        <ul style="list-style: none">
            <li>
                <label for="userid">아이디</label>
<%--                id는 for와 연결, name은 getParameter에서 사용--%>
                <input type="text" id="userid" name="userid">
            </li>
            <li>
                <label for="passwd">비밀번호</label>
                <input type="password" id="passwd" name="passwd"/>
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>