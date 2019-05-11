<%--
  Created by IntelliJ IDEA.
  User: FJ
  Date: 2019/5/11
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/TestServlet">123</a>
  <a href="${pageContext.request.contextPath}/TestServlet?action=add">add</a>
  <a href="${pageContext.request.contextPath}/TestServlet?action=delete">delete</a>
  <a href="${pageContext.request.contextPath}/TestServlet?action=update">update</a>
  </body>
</html>
