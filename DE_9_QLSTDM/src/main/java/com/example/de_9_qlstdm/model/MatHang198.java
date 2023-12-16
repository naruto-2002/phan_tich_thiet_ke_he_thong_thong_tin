package com.example.de_9_qlstdm.model;
public class MatHang198 {
    private int id;
    private String ten;
    private int gia;
    private String moTa;
    private int soLuong;

    public MatHang198() {
    }

    public MatHang198(String ten, int gia, String moTa, int soLuong) {
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.soLuong = soLuong;
    }

    public MatHang198(int id, String ten, int gia, String moTa, int soLuong) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.soLuong = soLuong;
    }

    public MatHang198(int id) {
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
