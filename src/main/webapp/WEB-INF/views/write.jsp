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
<input type="submit" value="write" onclick="show_alert()"/>
</form:form>
</body>
<script>
  function show_alert() {
    alert("글이 저장되었습니다.");
  }
</script>
</html>