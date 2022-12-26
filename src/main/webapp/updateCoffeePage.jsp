<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
	<h2>커피 메뉴 삭제</h2>

	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>사이즈</th>
			<th>가격</th>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.list || fn:length(list)==0}">
				<tr>
					<td>등록된 커피 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.list}" var="coffee">
					<tr>
						<td>${coffee.id}</td>
						<td>${coffee.name}</td>
						<td>${coffee.size}</td>
						<td>${coffee.price}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<br/>
    <form action="update" method="POST">
    <label for="coffee-id">수정하실 메뉴의 번호 :</label>
        <input type="text" id="coffee-id" name="coffeeId">
        <br />
        <br />
        <label for="coffee-name">커피 이름:</label>
        <input type="text" id="coffee-name" name="coffeeName">
        <p>커피 사이즈를 선택하세요 :)</p>
          <input type="radio" id="tall" name="coffeeSize" value="TALL">
          <label for="tall">TALL</label><br>
          <input type="radio" id="grande" name="coffeeSize" value="GRANDE">
          <label for="grande">GRANDE</label><br>
          <input type="radio" id="venti" name="coffeeSize" value="VENTI">
          <label for="venti">VENTI</label>
        <br /><br />
        <label for="coffee-price">가격:</label>
        <input type="number" id="coffee-price" name="coffeePrice">
        <br /><br />
        <button type="submit">수정하기</button>
    </form>
</body>
</html>