/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import model.Phim451;
import model.PhongChieu451;

/**
 *
 * @author Admin
 */
public class LichChieuDAO451 extends DAO451{
     public boolean themLichChieu(String gioBD,String gioKT,PhongChieu451 pc,Phim451 p) {
        String sql = "insert into tblLichChieu451(giobatdau,gioketthuc,tblphongchieu451Id,tblphim451id)\n" +
        "values(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, gioBD);
            st.setString(2,gioKT);
            st.setInt(3, pc.getId());
            st.setInt(4, p.getId());
            return st.executeUpdate()>0; // Thực hiện câu lệnh UPDATE
        } catch (SQLException e) {
            System.out.println(e.toString());
    }
        return false;
    }
    public static void main(String[] args) {
       PhongChieu451 pc = new PhongChieu451();
       pc.setId(1);
       Phim451  p = new Phim451();
       p.setId(3);
       System.out.println(new LichChieuDAO451().themLichChieu("2023-10-28 1:1:00", "2023-10-28 2:2:00", pc, p));
    }
}
