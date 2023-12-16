package com.example.de_9_qlstdm.dao;

import com.example.de_9_qlstdm.dal.DBContext;
import com.example.de_9_qlstdm.model.ThanhVien198;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThanhVienDAO198 extends DBContext {

    public List<ThanhVien198> selectAll(){
        String query = "select * from THANHVIEN";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            List<ThanhVien198> list = new ArrayList<>();
            while(rs.next()){
                ThanhVien198 tv;
                tv = new ThanhVien198(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(tv);
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

    public List<ThanhVien198> selectThanhVienByVaiTro(int _vaiTro) {
        String sql = "SELECT * FROM THANHVIEN WHERE vaiTro=?";
        PreparedStatement ps= null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, _vaiTro);
            rs = ps.executeQuery();
            List<ThanhVien198> list = new ArrayList<>();
            while(rs.next()){
                ThanhVien198 tv;
                tv = new ThanhVien198(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(tv);
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

    public ThanhVien198 selectThanhVienByEmailAndMatKhau(String email, String matKhau) {
        String sql = "SELECT * FROM THANHVIEN WHERE email=? AND matKhau=?";
        PreparedStatement ps= null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, matKhau);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id"); // Thay "id" bằng tên cột thực tế
                String ten = rs.getString("ten"); // Thay "ten" bằng tên cột thực tế
                String ngayThangNamSinh = rs.getString("ngayThangNamSinh"); // Tên cột khác tương tự
                String diaChi = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String _email = rs.getString("email");
                String _matKhau = rs.getString("matKhau");
                int vaiTro = rs.getInt("vaiTro");

                return new ThanhVien198(id, ten, ngayThangNamSinh, diaChi, sdt, _email, _matKhau, vaiTro);
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

    public ThanhVien198 selectThanhVienByID(int _id) {
        String sql = "SELECT * FROM THANHVIEN WHERE id=?";
        PreparedStatement ps= null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id"); // Thay "id" bằng tên cột thực tế
                String ten = rs.getString("ten"); // Thay "ten" bằng tên cột thực tế
                String ngayThangNamSinh = rs.getString("ngayThangNamSinh"); // Tên cột khác tương tự
                String diaChi = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String _email = rs.getString("email");
                String _matKhau = rs.getString("matKhau");
                int vaiTro = rs.getInt("vaiTro");

                return new ThanhVien198(id, ten, ngayThangNamSinh, diaChi, sdt, _email, _matKhau, vaiTro);
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

    public void insertThanhVien(ThanhVien198 tv) {
        String sql = "insert into THANHVIEN(ten, ngayThangNamSinh, diaChi, sdt, email, matKhau, vaiTro) values(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tv.getTen());
            preparedStatement.setString(2, tv.getNgayThangNamSinh());
            preparedStatement.setString(3, tv.getDiaChi());
            preparedStatement.setString(4, tv.getSdt());
            preparedStatement.setString(5, tv.getEmail());
            preparedStatement.setString(6, tv.getMatKhau());
            preparedStatement.setInt(7, tv.getVaiTro());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }
}
