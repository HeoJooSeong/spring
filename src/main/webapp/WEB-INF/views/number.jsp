<%@ include file="include/head.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring 실습</title>
    <style>
        .test{
            color: red;
        }
        #idtest{
            color: blue;
        }
    </style>
</head>
<body>
<c:forEach var="num" items="${num}">
    <h1>${num.name} , ${num.num}</h1>
</c:forEach>


</body>
</html>
