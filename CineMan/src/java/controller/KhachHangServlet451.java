/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.PhimDAO451;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;
import model.Phim451;

/**
 *
 * @author Admin
 */
public class KhachHangServlet451 extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      String viTri = request.getParameter("viTri");
      HttpSession session = request.getSession();
      List<Phim451> lsPhim = (List<Phim451>) session.getAttribute("dsPhimTheoTuKhoa");
      try{
      int vt = Integer.parseInt(viTri);
      vt-=1;
//      System.out.println("Vttt: "+vt);
      request.setAttribute("phim", lsPhim.get(vt));
      request.getRequestDispatcher("gdkhachhang/GDThongTinPhim451.jsp").forward(request, response);
      }
      catch(Exception e){
         e.printStackTrace();
      }
    } 

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String tuKhoa = request.getParameter("keyword");
       PhimDAO451 pd = new PhimDAO451();
       List<Phim451> lsPhim = pd.layPhimTheoThongTin(tuKhoa);
       HttpSession session = request.getSession();
       session.setAttribute("dsPhimTheoTuKhoa", lsPhim);
//       System.out.println("okkkkkkkkkkkkk12");
       request.setAttribute("dsPhim", lsPhim);
       request.setAttribute("tuKhoa",tuKhoa);
       request.getRequestDispatcher("gdkhachhang/GDTimPhim451.jsp").forward(request, response);
    }

}
