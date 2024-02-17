/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.LichChieuDAO451;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Phim451;
import model.PhongChieu451;

public class LichChieuServlet451 extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_phim = request.getParameter("selectedPhimId");
        HttpSession session = request.getSession();
        PhongChieu451 phong = (PhongChieu451) session.getAttribute("phongDuocChon");
        String bd = (String) session.getAttribute("start");
        String kt = (String) session.getAttribute("end");
        List<Phim451> dsPhim = (List<Phim451>) session.getAttribute("dsPhimDangChieu");
        for(Phim451 p:dsPhim){
            if(id_phim.equals(p.getId()+"")){
                LichChieuDAO451 lcd = new LichChieuDAO451();
                String message = "Thêm thất bại";
                if(lcd.themLichChieu(bd, kt, phong, p)){
                    message = "Thêm thành công";
                    request.setAttribute("phim1",p);
                }
                request.setAttribute("message",message);
                
                request.getRequestDispatcher("gdnhanvienql/GDChonPhim451.jsp").forward(request, response);
            }
        }
    }
}
