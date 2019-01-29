<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Form Test</title>
</head>
<body>
<form:form modelAttribute="board">
  subject: <form:input path="subject"/><br/>
  contents: <form:input path="contents"/><br/>
  <input type="submit" value="write"/>
</form:form>
</body>
</html>