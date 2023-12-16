<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang duyệt đơn</title>
    <link rel="stylesheet" href="./trang_duyet_don/style.css">
</head>
<body>
<div class="container">
    <h1 class="title-1">Duyệt đơn và xuất kho</h1>
    <c:set var = "hdm" value = "${requestScope.hdm}"/>
    <h2 class="title-2">Danh sách mặt hàng mua</h2>
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
<%--        id int identity(1,1) NOT NULL PRIMARY KEY,--%>
<%--        khachHangID int,--%>
<%--        nhanVienKhoID int,--%>
<%--        nhanVienGiaoHangID int,--%>
<%--        ngayMua nvarchar(225),--%>
<%--        ngayDuyet nvarchar(225),--%>
<%--        ngayGiao nvarchar(225),--%>
<%--        diaChi nvarchar(225),--%>
<%--        tongTien int,--%>
<%--        trangThaiDuyet bit,--%>
        <tr>
            <th>ID</th>
            <th>Khách hàng</th>
            <th>Nhân viên kho</th>
            <th>Ngày mua</th>
            <th>Địa chỉ</th>
            <th>Tổng tiền</th>
        </tr>
        <tr>
            <td>${hdm.id}</td>
            <td>ID: ${hdm.kh.id} | Tên: ${hdm.kh.ten} | Số điện thoại: ${hdm.kh.sdt}</td>
            <td>ID: ${hdm.nvk.id} | Tên: ${hdm.nvk.ten} | Số điện thoại: ${hdm.nvk.sdt}</td>
            <td>${hdm.ngayMua}</td>
            <td>${hdm.diaChi}</td>
            <td>${hdm.tongTien}đ</td>
        </tr>
    </table>
    <br>
    <h2 class="title-2">Chọn nhân viên giao hàng và điền ngày giao hàng</h2>
    <select id="select-shipper" name="select-shipper">
        <option value="${0}">Chọn nhân viên giao hàng</option>
        <c:forEach items="${requestScope.lnvgh}" var="nvgh" varStatus="loop">
            <option value="${nvgh.id}">ID: ${nvgh.id} | Tên:${nvgh.ten} | Số điện thoại:${nvgh.sdt}</option>
        </c:forEach>
    </select>
    <br>
    <br>
    <input type="text" name="delivery-date" id="delivery-date" placeholder="Ngày giao hàng">
    <br>
    <br>
    <br>
    <button id="save-btn" onclick="saveHandle(event, '${hdm.id}', '${hdm.nvk.id}')">Lưu</button>
    <button id="close-btn" onclick="closeHandle(event)">Đóng</button>
</div>
<script src="./trang_duyet_don/script.js"></script>
</body>
</html>
