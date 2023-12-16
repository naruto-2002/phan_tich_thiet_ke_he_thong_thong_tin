package com.example.de_9_qlstdm.model;
public class MatHangMua198 {
    private int id, hoaDonMuaID, khachHangID;
    private MatHang198 mh;
    private String ngayDat;
    private int soLuong, thanhTien, trangThai;

    public MatHangMua198() {
    }

    public MatHangMua198(int id) {
        this.id = id;
    }

    public MatHangMua198(int id, int hoaDonMuaID, int khachHangID, MatHang198 mh, String ngayDat, int soLuong, int thanhTien, int trangThai) {
        this.id = id;
        this.hoaDonMuaID = hoaDonMuaID;
        this.khachHangID = khachHangID;
        this.mh = mh;
        this.ngayDat = ngayDat;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHoaDonMuaID() {
        return hoaDonMuaID;
    }

    public void setHoaDonMuaID(int hoaDonMuaID) {
        this.hoaDonMuaID = hoaDonMuaID;
    }

    public int getKhachHangID() {
        return khachHangID;
    }

    public void setKhachHangID(int khachHangID) {
        this.khachHangID = khachHangID;
    }

    public MatHang198 getMh() {
        return mh;
    }

    public void setMh(MatHang198 mh) {
        this.mh = mh;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
