package com.example.de_9_qlstdm.dao;

import com.example.de_9_qlstdm.dal.DBContext;
import com.example.de_9_qlstdm.model.MatHang198;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatHangDAO198 extends DBContext {
    public List<MatHang198> selectAll(){
        String query = "select * from MATHANG";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            List<MatHang198> list = new ArrayList<>();
            while(rs.next()){
                MatHang198 mh;
                mh = new MatHang198(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
                list.add(mh);
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

    public List<MatHang198> selectMatHangByTen(String ten){
        String query = "select * from MATHANG WHERE Ten LIKE ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, ten + '%');
            rs = ps.executeQuery();
            List<MatHang198> list = new ArrayList<>();
            while(rs.next()){
                MatHang198 mh;
                mh = new MatHang198(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
                list.add(mh);
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

    public MatHang198 selectMatHangByID(int id){
        String query = "select * from MATHANG WHERE id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1,  id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new MatHang198(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
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

    public void updateSoLuong(int mhId, int soLuong) {
        String sql = "update MATHANG set soLuong=? where id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, mhId);

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
