<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang duyệt đơn</title>
    <link rel="stylesheet" href="./trang_chi_tiet_hoa_don_mua/style.css">
</head>
<body>
<div class="container">
    <h1 class="title-1">Hóa Đơn Mua</h1>
    <c:set var = "hdm" value = "${requestScope.hdm}"/>
    <h2 class="title-2">Danh sách mặt hàng mua</h2>
<%--    id int identity(1,1) NOT NULL PRIMARY KEY,--%>
<%--    hoaDonMuaID int,--%>
<%--    matHangID int,--%>
<%--    ngayDat nvarchar(255),--%>
<%--    soLuong int,--%>
<%--    thanhTien int,--%>
<%--    trangThai bit,--%>
    <table border="1px">
        <tr>
            <th>STT</th>
            <th>ID mặt hàng mua</th>
            <th>Ngày đặt</th>
            <th>Mặt hàng</th>
            <th>Số lượng mua</th>
            <th>Thành tiền</th>
        </tr>
        <c:forEach items="${hdm.lmhm}" var="mhm" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${mhm.id}</td>
                <td>${mhm.ngayDat}</td>
                <td>ID: ${mhm.mh.id} | Tên: ${mhm.mh.ten} | Giá: ${mhm.mh.gia}đ | Số lượng: ${mhm.mh.soLuong}</td>
                <td>${mhm.soLuong}</td>
                <td>${mhm.thanhTien}đ</td>
            </tr>
        </c:forEach>
    </table>
    <h2 class="title-2">Thông tin hóa đơn mua</h2>
    <table border="1px">
        <tr>
            <th>ID</th>
            <th>Khách hàng</th>
            <th>Nhân viên kho</th>
            <th>Nhân viên giao hàng</th>
            <th>Ngày mua</th>
            <th>Ngày giao hàng</th>
            <th>Ngày duyệt đơn</th>
            <th>Địa chỉ giao hàng</th>
            <th>Tổng tiền thanh toán</th>
        </tr>
        <tr>
            <td>${hdm.id}</td>
            <td>ID: ${hdm.kh.id} | Tên: ${hdm.kh.ten} | Số điện thoại: ${hdm.kh.sdt}</td>
            <td>ID: ${hdm.nvk.id} | Tên: ${hdm.nvk.ten} | Số điện thoại: ${hdm.nvk.sdt}</td>
            <td>ID: ${hdm.nvgh.id} | Tên: ${hdm.nvgh.ten} | Số điện thoại: ${hdm.nvgh.sdt}</td>
            <td>${hdm.ngayMua}</td>
            <td>${hdm.ngayGiao}</td>
            <td>${hdm.ngayDuyet}</td>
            <td>${hdm.diaChi}</td>
            <td>${hdm.tongTien}đ</td>
        </tr>
    </table>
    <br>
    <br>
    <button>In hóa đơn</button>
    <button id="close-btn" onclick="closeHandle(event)">Đóng</button>
</div>
<script src="./trang_chi_tiet_hoa_don_mua/script.js"></script>
</body>
</html>
