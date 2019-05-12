<%--
  Created by IntelliJ IDEA.
  User: FJ
  Date: 2019/5/11
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${ctx }/admin/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx }/admin/css/amazeui.min.css"/>
</head>
<body>

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">更新分类</strong>
            <small></small>
        </div>
    </div>
    <hr>

    <div class="edit_content">
        <form action="${ctx }/CategoryServlet?action=updateCategory" method="post" id="edit_form" style="background: none; width: 700px;">
            <div class="item1">

                <div>
                    <span>分类编号：</span>
                    <input type="text" readonly class="am-form-field" name="cid" value="${category.cid }">&nbsp;&nbsp;
                </div>
                <div>
                    <span>分类名称：</span>
                    <input type="text" class="am-form-field" name="cname" value="${category.cname }">
                </div>

            </div>

            <button class="am-btn am-btn-default" type="button" id="edit">更新</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button class="am-btn am-btn-default" type="button" id="reset">重置</button>
        </form>
    </div>

</div>

</body>

<script src="${ctx }/admin/js/jquery.min.js"></script>

<script>
    $("#edit").click(function () {
        $("#edit_form").submit();
    })

</script>

</html>
