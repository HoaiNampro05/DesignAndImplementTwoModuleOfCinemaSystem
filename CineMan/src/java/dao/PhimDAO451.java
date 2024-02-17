/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Phim451;

/**
 *
 * @author Admin
 */
public class PhimDAO451 extends DAO451{
     public List<Phim451> layPhimDangChieu(){
            String sql = "select * from tblPhim451 where trangthai =?";
            try{
            List<Phim451> ls = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setBoolean(1, true);
            ResultSet rs=st.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String tenPhim = rs.getString("tenPhim");
                    String anhMinhHoa = rs.getString("anhMinhHoa");
                    String theLoai = rs.getString("theLoai");
                    String moTa = rs.getString("moTa");
                    int namPhatHanh = rs.getInt("namPhatHanh");
                    boolean trangThai = rs.getBoolean("trangThai");
                    Phim451 phim = new Phim451(id, tenPhim, anhMinhHoa, theLoai, moTa, namPhatHanh, trangThai);
                    ls.add(phim);
                }
            return ls;
            }
            catch(SQLException e){
                System.out.println(e.toString());
            }   
            return null;
    }
     public List<Phim451> layPhimTheoThongTin(String tuKhoa){
            String sql = "select * from tblPhim451 where tenphim LIKE ?";
            try{
            List<Phim451> ls = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%"+tuKhoa+"%");
            ResultSet rs=st.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String tenPhim = rs.getString("tenPhim");
                    String anhMinhHoa = rs.getString("anhMinhHoa");
                    String theLoai = rs.getString("theLoai");
                    String moTa = rs.getString("moTa");
                    int namPhatHanh = rs.getInt("namPhatHanh");
                    boolean trangThai = rs.getBoolean("trangThai");
                    Phim451 phim = new Phim451(id, tenPhim, anhMinhHoa, theLoai, moTa, namPhatHanh, trangThai);
                    ls.add(phim);
                }
            return ls;
            }
            catch(SQLException e){
                System.out.println(e.toString());
            }   
            return null;
    }
    public boolean themPhimDangChieu(Phim451 phim){
        String sql = "INSERT INTO tblphim451(tenphim, anhminhhoa, theloai, mota, namphathanh, trangthai) VALUES (?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, phim.getTenPhim());
            st.setString(2, phim.getAnhMinhHoa());
            st.setString(3, phim.getTheLoai());
            st.setString(4, phim.getMoTa());
            st.setInt(5, phim.getNamPhatHanh());
            st.setBoolean(6, phim.getTrangThai());
            return (st.executeUpdate()>0);
            }
            catch(SQLException e){
                System.out.println(e.toString());
            }   
            return false;
    }
  
}
