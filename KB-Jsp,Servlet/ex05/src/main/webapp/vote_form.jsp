<%--
  Created by IntelliJ IDEA.
  User: hoonssac
  Date: 2025. 6. 4.
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>🍪 우리 반 인기 간식 투표</h1>
<fieldset>
    <legend>
        좋아하는 간식을 하나 골라주세요
    </legend>
    <form action="/vote-submit" method="post">

        <input type="radio" value="와사비과자" name="snack">와사비과자<br>
        <input type="radio" value="붕어빵" name="snack">붕어빵<br>
        <input type="radio" value="쿠쉬쿠쉬" name="snack">쿠쉬쿠쉬<br>
        <input type="radio" value="초코하임" name="snack">초코하임<br>
        <input type="radio" value="몽쉘" name="snack">몽쉘<br>
        <input type="radio" value="커스타드" name="snack">커스타드<br>
        <input type="radio" value="쿠크다스" name="snack">쿠크다스<br>
        <input type="radio" value="초코파이" name="snack">초코파이<br>
        <input type="radio" value="꿀꽈배기" name="snack">꿀꽈배기<br><br>
        <button type="submit">투표하기</button>
    </form>

</fieldset>
</body>
</html>
