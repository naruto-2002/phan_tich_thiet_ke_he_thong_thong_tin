<%--
  Created by IntelliJ IDEA.
  User: vanUser1
  Date: 11/8/2023
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="./trang_chu/style.css">
</head>
<body>
    <div class="member-container">
        <%@include file="../dau_trang/index.jsp"%>
        <c:if test = "${tv.vaiTro == null}">
            <h3>Chào mừng đến với hệ thống quản lý siêu thị điện máy</h3>
        </c:if>
        <c:if test = "${tv.vaiTro == 1}">
            <h3>Chào mừng khách hàng ${tv.ten} đến với hệ thống quản lý siêu thị điện máy</h3>
        </c:if>
        <c:if test = "${tv.vaiTro == 2}">
            <h3>Chào mừng nhân viên kho ${tv.ten} đến với hệ thống quản lý siêu thị điện máy</h3>
        </c:if>
    </div>
</body>
</html>
