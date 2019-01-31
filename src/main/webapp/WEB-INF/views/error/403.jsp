<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Spring 실습</title>
</head>
<body>
<%@ include file="../include/headerBar.jsp" %>
<h1>권한이 없습니다.</h1>
<img src="/resources/images/spring.png"/><br/>
HELLO WORLD !!~~~~~
${a}
<sec:authorize access="isAuthenticated()">
    <a href="/user/list">회원 리스트 보기</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_TEST')">
   이 화면은 ROLE_TEST에서만 보입니다.
</sec:authorize>
</body>
</html>
