package com.example.de_9_qlstdm.dao;

import com.example.de_9_qlstdm.dal.DBContext;
import com.example.de_9_qlstdm.model.MatHang198;
import com.example.de_9_qlstdm.model.MatHangMua198;
import com.example.de_9_qlstdm.model.ThanhVien198;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatHangMuaDAO198 extends DBContext {
    public List<MatHangMua198> selectMatHangMuaByHoaDonMuaID(int hdmId){
        String query = "select * from MATHANGMUA where hoaDonMuaID=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1,hdmId);
            rs = ps.executeQuery();
            List<MatHangMua198> list = new ArrayList<>();
            while(rs.next()){
                MatHangMua198 mhm;
                mhm = new MatHangMua198(rs.getInt(1), rs.getInt(2), rs.getInt(3), new MatHang198(rs.getInt(4)), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                list.add(mhm);
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
}
