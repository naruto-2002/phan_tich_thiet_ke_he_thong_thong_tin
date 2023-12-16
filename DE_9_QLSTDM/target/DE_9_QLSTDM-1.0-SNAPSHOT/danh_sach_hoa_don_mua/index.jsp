<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách đơn hàng</title>
    <link rel="stylesheet" href="./danh_sach_hoa_don_mua/style.css">
</head>
<body>
    <div class="container">
        <%@include file="../dau_trang/index.jsp"%>
        <c:if test = "${tv.vaiTro == 2}">
            <h1 class="title">Danh sách hóa đơn mua</h1>
            <table class="bill-list">
                <tr>
                    <th>STT</th>
                    <th>ID</th>
                    <th>Khách hàng</th>
                    <th>Ngày mua</th>
                    <th>Địa chỉ</th>
                    <th>Tổng tiền</th>
                    <th>Trạng thái duyệt</th>
                    <th colspan="2">Nút điều khiển</th>
                </tr>
                <c:forEach items="${requestScope.lhdm}" var="hdm" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${hdm.id}</td>
                        <td>ID: ${hdm.kh.id} | Tên: ${hdm.kh.ten} | Số điện thoại: ${hdm.kh.sdt}</td>
                        <td>${hdm.ngayMua}</td>
                        <td>${hdm.diaChi}</td>
                        <td>${hdm.tongTien}đ</td>
                        <td>${(hdm.trangThaiDuyet == 1?"Đã duyệt": "Chưa duyệt")}</td>
                        <td >
                            <button onclick="detailBill('${hdm.id}')" ${(hdm.trangThaiDuyet == 1?"":"disabled")}>Xem chi tiết</button>
                            <button onclick="approveBill('${hdm.id}', '${tv.id}')" >Duyệt đơn</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <script src="./danh_sach_hoa_don_mua/script.js"></script>
</body>
</html>
