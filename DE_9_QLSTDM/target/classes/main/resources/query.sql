create database "DE_9_QLST";

use DE_9_QLST;

create table THANHVIEN (
                           id int identity(1,1) NOT NULL PRIMARY KEY,
                           ten nvarchar(225),
                           ngayThangNamSinh date,
                           diaChi nvarchar(225),
                           sdt nvarchar(20),
                           email nvarchar(225),
                           matKhau nvarchar(225),
                           vaiTro int,
);

insert into THANHVIEN(ten, ngayThangNamSinh, diaChi, sdt, email, matKhau, vaiTro)
values(N'Tạ Quang Toàn', '10/09/2002', N'Nam Định', '75954095', 'toan@gmail.com', N'toan123', 1);

insert into THANHVIEN(ten, ngayThangNamSinh, diaChi, sdt, email, matKhau, vaiTro)
values(N'Ngô Sỹ Tuấn', '11/05/2002', N'Thanh Hóa', '885947', 'tuan@gmail.com', N'tuan123', 1);

insert into THANHVIEN(ten, ngayThangNamSinh, diaChi, sdt, email, matKhau, vaiTro)
values(N'Nguyễn Quang Huy', '06/21/2002', N'Nghệ An', '54367578', 'huy@gmail.com', N'huy123', 1);

insert into THANHVIEN(ten, ngayThangNamSinh, diaChi, sdt, email, matKhau, vaiTro)
values(N'Nguyễn Công Văn', '10/02/2002', N'Hà Nam', '48854905', 'van@gmail.com', N'van123', 2);

insert into THANHVIEN(ten, ngayThangNamSinh, diaChi, sdt, email, matKhau, vaiTro)
values
    (N'Đỗ Ngọc Sơn', '03/09/2002', N'Vĩnh Phúc', '5949675', 'son@gmail.com', N'son123', 3),
    (N'Phan Minh Tiến', '02/07/2002', N'Nghệ An', '5494894', 'tien@gmail.com', N'tien123', 3),
    (N'Nguyễn Tiến Quân', '09/10/2002', N'Thanh Hóa', '09448945', 'quan@gmail.com', N'quan123', 3);

select * from THANHVIEN
select * from THANHVIEN where email='toan@gmail.com' and matKhau='toan123'

create table MATHANG (
                         id int identity(1,1) NOT NULL PRIMARY KEY,
                         ten nvarchar(225),
                         gia int,
                         moTa nvarchar(1000),
                         soLuong int,
);

insert into MATHANG(ten, gia, moTa, soLuong)
values
    (N'Tủ lạnh', 10000000, N'Được sản xuất tại Nhật Bản.', 100),
    (N'Nồi cơm điện', 300000, N'Được sản xuất tại Mĩ', 200),
    (N'Lò vi sóng', 5000000, N'Được sản xuất tại Ấn Độ', 150),
    (N'Máy giặt', 20000000, N'Được sản xuất tại Trung Quốc', 250);

select * from MATHANG
select * from THANHVIEN where email='toan@gmail.com' and matKhau='toan123'

create table HOADONMUA (
                           id int identity(1,1) NOT NULL PRIMARY KEY,
                           khachHangID int,
                           nhanVienKhoID int,
                           nhanVienGiaoHangID int,
                           ngayMua nvarchar(225),
                           ngayDuyet nvarchar(225),
                           ngayGiao nvarchar(225),
                           diaChi nvarchar(225),
                           tongTien int,
                           trangThaiDuyet bit,
                           FOREIGN KEY (khachHangID) REFERENCES THANHVIEN(id),
                           FOREIGN KEY (nhanVienKhoID) REFERENCES THANHVIEN(id),
                           FOREIGN KEY (nhanVienGiaoHangID) REFERENCES THANHVIEN(id),
);

insert into HOADONMUA(khachHangID, nhanVienKhoID, nhanVienGiaoHangID, ngayMua, ngayDuyet, ngayGiao, diaChi, tongTien, trangThaiDuyet)
values(3, null, null, '04/11/2023', null, null, N'Hà Nội', 25900000, 0);

insert into HOADONMUA(khachHangID, nhanVienKhoID, nhanVienGiaoHangID, ngayMua, ngayDuyet, ngayGiao, diaChi, tongTien, trangThaiDuyet)
values(1, null, null, '05/11/2023', null, null, N'Thành Phố Hồ Chí Minh', 40000000, 0);

insert into HOADONMUA(khachHangID, nhanVienKhoID, nhanVienGiaoHangID, ngayMua, ngayDuyet, ngayGiao, diaChi, tongTien, trangThaiDuyet)
values(2, null, null, '06/11/2023', null, null, N'Đà Nẵng', 35600000, 0);

select * from HOADONMUA


create table MATHANGMUA (
                            id int identity(1,1) NOT NULL PRIMARY KEY,
                            hoaDonMuaID int,
                            khachHangID int,
                            matHangID int,
                            ngayDat nvarchar(255),
                            soLuong int,
                            thanhTien int,
                            trangThai bit,
                            FOREIGN KEY (khachHangID) REFERENCES THANHVIEN(id),
                            FOREIGN KEY (hoaDonMuaID) REFERENCES HOADONMUA(id),
                            FOREIGN KEY (matHangID) REFERENCES MATHANG(id),
);


insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(1, 3, 1, '05/10/2023', 2, 20000000, 1);
insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(1, 3, 3, '04/10/2023', 1, 5000000, 1);
insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(1, 3, 2, '03/10/2023', 3, 900000, 1);

insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(2, 1, 4, '01/09/2023', 1, 20000000, 1);
insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(2, 1, 1, '04/09/2023', 1, 10000000, 1);
insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(2, 1, 3, '06/09/2023', 2, 10000000, 1);

insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(3, 2, 2, '10/10/2023', 2, 600000, 1);
insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(3, 2, 3, '01/11/2023', 3, 15000000, 1);
insert into MATHANGMUA(hoaDonMuaID, khachHangID, matHangID, ngayDat, soLuong, thanhTien, trangThai)
values(3, 2, 4, '02/11/2023', 1, 20000000, 1);

select * from MATHANGMUA

