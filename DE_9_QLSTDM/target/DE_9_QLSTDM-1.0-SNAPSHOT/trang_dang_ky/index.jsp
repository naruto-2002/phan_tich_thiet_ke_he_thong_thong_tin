
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang đăng ký</title>
    <link rel="stylesheet" href="./trang_dang_ky/style.css">
</head>
<body>
    <div class="form-register-container">
        <h1>Đăng Ký</h1>
        <form class="form-register-body" action="dang-ky" method="post">
            <input type="text" name="member-name" id="member-name" placeholder="Tên" >
            <br/>
            <input type="text" name="date-of-birth" id="date-of-birth"  placeholder="Ngày tháng năm sinh" >
            <br/>
            <input type="text" name="address" id="country" placeholder="Địa chỉ" >
            <br/>
            <input type="text" name="phone-number" id="phone-number"  placeholder="Số điện thoại" >
            <br/>
            <input type="email" name="email" id="email" placeholder="Email" >
            <br/>
            <input type="password" name="password" id="password" placeholder="Mật khẩu" >
            <br/>
            <input type="password" name="re-enter-password" id="re-enter-password"  placeholder="Nhập lại mật khẩu" >
            <br/>
            <br/>
            <input type="submit" value="Đăng ký">
            <button type="button" id="login-btn">Đăng nhập</button>
        </form>
    </div>
    <script src="./trang_dang_ky/script.js"></script>
</body>
</html>
