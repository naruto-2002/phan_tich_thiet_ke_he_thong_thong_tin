package com.example.de_9_qlstdm.model;

public class ThanhVien198 {
    private int id;
    private String ten, ngayThangNamSinh, diaChi, sdt, email, matKhau;
    private int vaiTro;

    public ThanhVien198(int id, String ten, String ngayThangNamSinh, String diaChi, String sdt, String email, String matKhau, int vaiTro) {
        this.id = id;
        this.ten = ten;
        this.ngayThangNamSinh = ngayThangNamSinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public ThanhVien198(String ten, String ngayThangNamSinh, String diaChi, String sdt, String email, String matKhau, int vaiTro) {
        this.ten = ten;
        this.ngayThangNamSinh = ngayThangNamSinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public ThanhVien198() {

    }

    public ThanhVien198(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgayThangNamSinh() {
        return ngayThangNamSinh;
    }

    public void setNgayThangNamSinh(String ngayThangNamSinh) {
        this.ngayThangNamSinh = ngayThangNamSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }
}
