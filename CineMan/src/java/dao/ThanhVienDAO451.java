/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.KhachHang451;
import model.NhanVien451;
import model.ThanhVien451;

/**
 *
 * @author Admin
 */
public class ThanhVienDAO451 extends DAO451{
    public ThanhVien451 layThanhVienByUsernamePass(String username,String password){
            String sql = "select * from tblthanhvien451 where tendangnhap= ? and matkhau = ?";
            try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                    ThanhVien451 thanhVien = new ThanhVien451();
                    thanhVien.setId(rs.getInt("id"));
                    thanhVien.setTenDangNhap(rs.getString("tendangnhap"));
                    thanhVien.setMatKhau(rs.getString("matkhau"));
                    thanhVien.setTen(rs.getString("ten"));
                    thanhVien.setNgaySinh(rs.getDate("ngaysinh"));
                    thanhVien.setEmail(rs.getString("email"));
                    thanhVien.setSoDienThoai(rs.getString("sodienthoai"));
                    thanhVien.setGhiChu(rs.getString("ghichu"));
                    return thanhVien;
            }
            }
            catch(SQLException e){
                System.out.println(e.toString());
            }   
            return null;
    }
    public KhachHang451 layKhachHang(String username,String password){
        ThanhVien451 tv=new ThanhVienDAO451().layThanhVienByUsernamePass(username, password);
        String sql = "select * from tblkhachhang451 where id=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,tv.getId()+"");
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                    String maKH = rs.getString("makhachhang");
                    KhachHang451 kh = new KhachHang451(tv.getId(),tv.getTenDangNhap(),tv.getMatKhau(),tv.getTen(),
                            tv.getNgaySinh(),tv.getEmail(),tv.getSoDienThoai(),tv.getGhiChu(),maKH,null);
                    return kh;
            }
            }
            catch(SQLException e){
                System.out.println(e.toString());
            }   
            return null;
    }
    public NhanVien451 layNhanVien(String username,String password){
        ThanhVien451 tv=new ThanhVienDAO451().layThanhVienByUsernamePass(username, password);
        String sql = "select * from tblnhanvien451 where id=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,tv.getId()+"");
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                    String vitri = rs.getString("vitri");
                    NhanVien451 nv = new NhanVien451(tv.getId(),tv.getTenDangNhap(),tv.getMatKhau(),tv.getTen(),
                            tv.getNgaySinh(),tv.getEmail(),tv.getSoDienThoai(),tv.getGhiChu(),vitri);
                    return nv;
            }
            }
            catch(SQLException e){
                System.out.println(e.toString());
            }   
            return null;
    }
}
