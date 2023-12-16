
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang đăng nhập</title>
    <link rel="stylesheet" href="./trang_dang_nhap/style.css">
</head>
<body>
    <div class="form-login-container">
        <h1>Đăng Nhập</h1>
        <form class="form-login-body" action="dang-nhap" method="post">
            <input type="email" name="email" id="email" placeholder="Email" >
            <br/>
            <input type="password" name="password" id="password" placeholder="Mật khẩu" >
            <br/>
            <br/>
            <input type="submit" value="Đăng nhập">
            <button type="button" id="register-btn">Đăng ký</button>
        </form>

    </div>
    <script src="./trang_dang_nhap/script.js"></script>
</body>

</html>
