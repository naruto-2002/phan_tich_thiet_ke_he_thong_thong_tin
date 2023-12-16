package com.example.de_9_qlstdm.dao;

import com.example.de_9_qlstdm.dal.DBContext;
import com.example.de_9_qlstdm.model.HoaDonMua198;
import com.example.de_9_qlstdm.model.ThanhVien198;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonMuaDAO198 extends DBContext {
    public List<HoaDonMua198> selectAll(){
        String query = "select * from HOADONMUA";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            List<HoaDonMua198> list = new ArrayList<>();
            while(rs.next()){
                HoaDonMua198 hdm;
                hdm = new HoaDonMua198(rs.getInt(1), new ThanhVien198(rs.getInt(2)), new ThanhVien198(rs.getInt(3)), new ThanhVien198(rs.getInt(4)), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10));
                list.add(hdm);
            }
            return list;
        } catch (SQLException ex) {
            // Xử lý hoặc ghi log cho ngoại lệ nếu cần
            ex.printStackTrace();
        } finally {
            // Đảm bảo giải phóng tài nguyên sau khi sử dụng
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public HoaDonMua198 selectHoaDonMuaByID(int id){
        String query = "select * from HOADONMUA WHERE id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1,  id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new HoaDonMua198(rs.getInt(1), new ThanhVien198(rs.getInt(2)), new ThanhVien198(rs.getInt(3)), new ThanhVien198(rs.getInt(4)), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10));
            }

        } catch (SQLException ex) {
            // Xử lý hoặc ghi log cho ngoại lệ nếu cần
            ex.printStackTrace();
        } finally {
            // Đảm bảo giải phóng tài nguyên sau khi sử dụng
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public void updateHoaDonMua(int hdmId,int nvkId, int nvghId, String ngayDuyet, String ngayGiao) {
        String sql = "update HOADONMUA set nhanVienKhoID=?, nhanVienGiaoHangID=?, ngayDuyet=?, ngayGiao=?, trangThaiDuyet=? where id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, nvkId);
            ps.setInt(2, nvghId);
            ps.setString(3, ngayDuyet);
            ps.setString(4, ngayGiao);
            ps.setInt(5, 1);
            ps.setInt(6, hdmId);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            // Đảm bảo giải phóng tài nguyên sau khi sử dụng
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
