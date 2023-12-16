<%--
  Created by IntelliJ IDEA.
  User: vanUser1
  Date: 9/15/2023
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item detail</title>
    <link rel="stylesheet" href="./trang_chi_tiet_mat_hang/style.css">
</head>
<body>
    <div class="container">
        <h1 class="title">Thông tin chi tiết mặt hàng</h1>
        <c:set var = "mh" value = "${requestScope.matHang}"/>
        <div class="info-item">
            <h3 class="label">Name:</h3>
            <p class="description">${mh.ten}</p>
        </div>
        <div class="info-item">
            <h3 class="label">Giá:</h3>
            <p class="description">${mh.gia}đ</p>
        </div>
        <div class="info-item">
            <h3 class="label">Số lượng:</h3>
            <p class="description">${mh.soLuong}</p>
        </div>
        <div class="info-item">
            <h3 class="label">Mô tả chi tiết:</h3>
            <p class="description">${mh.moTa}</p>
        </div>
        <button id="close-btn">Đóng</button>
    </div>
    <script src="./trang_chi_tiet_mat_hang/script.js"></script>
</body>
</html>
