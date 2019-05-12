<%--
  Created by IntelliJ IDEA.
  User: FJ
  Date: 2019/5/11
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx",ctx);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加商品</strong><small></small></div>
    </div>
    <hr>

    <div class="edit_content">
        <form action="${ctx }/GoodsServlet?action=addGoods" method="post" id="add_form" style="background: none; width: 700px;">
            <div class="item1">
                <div>
                    <span>分类编号：</span>
                    <input type="text" readonly class="am-form-field" value="${category.cid}" name="cid">&nbsp;&nbsp;
                </div>
                <div>
                    <span>分类名称：</span>
                    <input type="text" class="am-form-field" name="cname">
                </div>

            </div>
            <button class="am-btn am-btn-default" type="button" id="add">添加</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button class="am-btn am-btn-default" type="button" id="reset">重置</button>
        </form>
    </div>

</div>
</body>
</html>
