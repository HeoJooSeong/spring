<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

    <title>index</title>

</head>
<body>

<br/><br/>
<a href="/board/write"><h1>게시판 글 쓰기</h1></a>
<img src="/resources/images/spring.png"/><br/>
subject : ${board.subject}<br/>
contents: ${board.contents}<br/>
dateTime: ${board.dateTime}<br/>
hits : ${board.hits}
</body>
</html>
