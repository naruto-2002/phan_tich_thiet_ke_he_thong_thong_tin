<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách mặt hàng</title>
    <link rel="stylesheet" href="./danh_sach_mat_hang/style.css">
</head>
<body>
<div class="container">
    <%@include file="../dau_trang/index.jsp"%>
    <c:if test = "${tv.vaiTro == 1}">
        <h1 class="title">Danh sách mặt hàng</h1>
        <form class="search-for-items" action="danh-sach-mat-hang">
            <input type="text" name="search-value" id="search">
            <input type="submit" value="Tìm kiếm">
        </form>
        <table class="item-list">
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Tên mặt hàng</th>
                <th>Giá cả</th>
                <th>Số lượng</th>
                <th ></th>
            </tr>
            <c:forEach items="${requestScope.lmh}" var="mh" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${mh.id}</td>
                    <td>${mh.ten}</td>
                    <td>${mh.gia}đ</td>
                    <td>${mh.soLuong}</td>
                    <td >
                        <button onclick="detailItem('${mh.id}')">Xem chi tiết</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>
<script src="./danh_sach_mat_hang/script.js"></script>
</body>
</html>
