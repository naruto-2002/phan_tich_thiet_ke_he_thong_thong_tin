<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.example.de_9_qlstdm.model.ThanhVien198" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đầu trang</title>
    <link rel="stylesheet" href="./dau_trang/style.css">
</head>
<body>
    <%
        String json = (String) session.getAttribute("thanhVien");
        Gson gson = new Gson();
        ThanhVien198 thanhVien = gson.fromJson(json, ThanhVien198.class);
    %>
    <c:set var = "tv" value = "<%= thanhVien %>"/>
    <c:if test = "${tv.vaiTro == null}">
        <button id="home-btn" onclick="homeBtnHandle(event)">Trang chủ</button>
        <button id="member-btn" onclick="memberBtnHandle(event)" >Thành viên</button>
    </c:if>
    <c:if test = "${tv.vaiTro == 1}">
        <button id="home-btn" onclick="homeBtnHandle(event)">Trang chủ</button>
        <button id="item-list-btn" onclick="itemListBtnHandle(event)">Danh sách mặt hàng</button>
        <button id="logout-btn" onclick="logoutBtnHandle(event)">Đăng xuất</button>
    </c:if>
    <c:if test = "${tv.vaiTro == 2}">
        <button id="home-btn" onclick="homeBtnHandle(event)">Trang chủ</button>
        <button id="item-list-btn" onclick="billListBtnHandle(event)">Danh sách hóa đơn mua</button>
        <button id="logout-btn" onclick="logoutBtnHandle(event)">Đăng xuất</button>
    </c:if>


<script src="./dau_trang/script.js"></script>
</body>
</html>
