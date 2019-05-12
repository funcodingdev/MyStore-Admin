<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx",ctx);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${ctx}/admin/css/amazeui.min.css" />
    <link rel="stylesheet" href="${ctx}/admin/js/pageStyle.css">
    <script src="js/jquery.min.js"></script>
</head>
<body>


<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">分类管理</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 添加分类</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="goods_list" id="account_List">
    <ul class="title_ul">
        <li>序号</li>
        <li>分类名称</li>
        <li>修改分类</li>
        <li>删除分类</li>
    </ul>

    <c:forEach items="${allCategory}" var="category">

        <ul class="list_goods_ul">
            <li>${category.cid}</li>
            <li>${category.cname}</li>
            <li><a href="${ctx}/CategoryServlet?action=updateCategoryUI&id=${category.cid}"><img class="img_icon" src="${ctx}/admin/images/edit_icon.png" alt=""></a></li>
            <li><a href="${ctx}/CategoryServlet?action=deleteCategory&id=${category.cid}"><img class="img_icon" src="${ctx}/admin/images/delete_icon.png" alt=""></a></li>
        </ul>

    </c:forEach>
</div>

<div id="modal_view">


</div>

<div id="modal_content">
    <div id="close"><img src="${ctx}/admin/images/delete_icon.png" alt=""></div>
    <div class="edit_content">

        <div class="item1">
            <div>
                <span>添加分类：</span>
            </div>
        </div>
        <div class="item1">
            <div>
                <span>分类名称：</span>
                <input type="text" class="am-form-field" id="cname">&nbsp;&nbsp;
            </div>
        </div>
        <div class="item1">
            <button class="am-btn am-btn-default" type="button" id="submitAdd" >添加</button>
        </div>
    </div>

</div>

<script src="${ctx}/admin/js/jquery.min.js"></script>

<script>
    $(function () {
        $('#add').click(function () {
            $("#modal_view").fadeIn();
            $("#modal_content").fadeIn();
        });

        $("#close").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content").fadeOut();
        });

        $('#submitAdd').click(function () {
            var cname = document.getElementById("cname");
            window.location.href="${ctx}/CategoryServlet?action=addCategory&cname="+cname.value;
            $("#modal_view").fadeOut();
            $("#modal_content").fadeOut();
        });

    });
</script>
</body>
</html>