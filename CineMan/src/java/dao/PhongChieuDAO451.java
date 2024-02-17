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
import model.PhongChieu451;

/**
 *
 * @author Admin
 */
public class PhongChieuDAO451 extends DAO451{
     public List<PhongChieu451> layPhongTrong(String start,String end){
            List<PhongChieu451> dsPhongChieu = new ArrayList<>();
            String sql = "SELECT *\n" +
                        "FROM tblphongchieu451\n" +
                        "WHERE id NOT IN (\n" +
                        "    SELECT DISTINCT tblphongchieu451id\n" +
                        "    FROM tbllichchieu451\n" +
                        "    WHERE (giobatdau <= ? AND gioketthuc >=?)\n" +
                        ");";
            try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,end);
            st.setString(2,start);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String viTri = rs.getString("viTri");
                int sucChua = rs.getInt("sucChua");
                String moTa = rs.getString("moTa");
                PhongChieu451 phongChieu = new PhongChieu451(id, ten, viTri, sucChua, moTa);
                dsPhongChieu.add(phongChieu);
            }
            return dsPhongChieu;
            }
            catch(SQLException e){
                System.out.println(e.toString());
            }   
            return null;
    }
  
}
