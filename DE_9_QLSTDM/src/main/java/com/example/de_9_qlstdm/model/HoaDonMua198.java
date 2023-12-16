package com.example.de_9_qlstdm.model;

import java.util.List;
public class HoaDonMua198 {
    private int id;
    private ThanhVien198 kh;
    private ThanhVien198 nvk;
    private ThanhVien198 nvgh;
    private String ngayMua, ngayDuyet, ngayGiao, diaChi;
    private int tongTien, trangThaiDuyet;

    private List<MatHangMua198> lmhm;

    public HoaDonMua198() {
    }

    public HoaDonMua198(int id) {
        this.id = id;
    }

    public HoaDonMua198(int id, ThanhVien198 kh, ThanhVien198 nvk, ThanhVien198 nvgh, String ngayMua, String ngayDuyet, String ngayGiao, String diaChi, int tongTien, int trangThaiDuyet) {
        this.id = id;
        this.kh = kh;
        this.nvk = nvk;
        this.nvgh = nvgh;
        this.ngayMua = ngayMua;
        this.ngayDuyet = ngayDuyet;
        this.ngayGiao = ngayGiao;
        this.diaChi = diaChi;
        this.tongTien = tongTien;
        this.trangThaiDuyet = trangThaiDuyet;
    }

    public HoaDonMua198(int id, ThanhVien198 kh, ThanhVien198 nvk, ThanhVien198 nvgh, String ngayMua, String ngayDuyet, String ngayGiao, String diaChi, int tongTien, int trangThaiDuyet, List<MatHangMua198> lmhm) {
        this.id = id;
        this.kh = kh;
        this.nvk = nvk;
        this.nvgh = nvgh;
        this.ngayMua = ngayMua;
        this.ngayDuyet = ngayDuyet;
        this.ngayGiao = ngayGiao;
        this.diaChi = diaChi;
        this.tongTien = tongTien;
        this.trangThaiDuyet = trangThaiDuyet;
        this.lmhm = lmhm;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ThanhVien198 getKh() {
        return kh;
    }

    public void setKh(ThanhVien198 kh) {
        this.kh = kh;
    }

    public ThanhVien198 getNvk() {
        return nvk;
    }

    public void setNvk(ThanhVien198 nvk) {
        this.nvk = nvk;
    }

    public ThanhVien198 getNvgh() {
        return nvgh;
    }

    public void setNvgh(ThanhVien198 nvgh) {
        this.nvgh = nvgh;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(String ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }

    public String getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(String ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThaiDuyet() {
        return trangThaiDuyet;
    }

    public void setTrangThaiDuyet(int trangThaiDuyet) {
        this.trangThaiDuyet = trangThaiDuyet;
    }

    public List<MatHangMua198> getLmhm() {
        return lmhm;
    }

    public void setLmhm(List<MatHangMua198> lmhm) {
        this.lmhm = lmhm;
    }
}
