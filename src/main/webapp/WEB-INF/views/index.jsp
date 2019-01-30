<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>​
<html>

    <title>index</title>

</head>
<body>

<br/><br/>
<a href="/board/write"><h1>게시판 글 쓰기</h1></a>
<img src="/resources/images/spring.png"/><br/>


<br/><br/>


<table style="border:1px solid black">
    <tr>
        <td></td>
        <td>제목</td>
        <td>내용</td>
        <td>조회수</td>
        <td>날짜</td>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <td></td>
        </sec:authorize>
    </tr>
    <c:forEach var = "u" varStatus = "varStatus" items="${board}">
        <tr>
            <td>${varStatus.count}</td>
            <td>${u.subject}</td>
            <td>${u.contents}</td>
            <td>${u.hits}</td>
            <td><fmt:formatDate value="${u.dateTime}" pattern="yyyy.MM.dd"/></td>

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td>

                    <a href="/board/edit?id=${u.id}">수정</a>
                    <a href="/board/delete?id=${u.id}">삭제</a>

                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>
</body>
</html>
