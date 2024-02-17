/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.PhimDAO451;
import dao.PhongChieuDAO451;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Phim451;
import model.PhongChieu451;
/**
 *
 * @author Admin
 */
public class PhongChieuServlet451 extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String start_hour = request.getParameter("start-hour");
       String start_min = request.getParameter("start-minute");
       String start_date = request.getParameter("start-date");
       String end_hour = request.getParameter("end-hour");
       String end_min = request.getParameter("end-minute");
       String end_date = request.getParameter("end-date");
//       System.out.println(start_date);
       String start = start_date+" "+start_hour+":"+start_min+":00";
       String end = end_date+" "+end_hour+":"+end_min+":00";
       HttpSession session = request.getSession();
       session.setAttribute("startHour",start_hour+":"+start_min+":00");
       session.setAttribute("endHour",end_hour+":"+end_min+":00");
       session.setAttribute("startDay",start_date);
       session.setAttribute("endDay",end_date);
       session.setAttribute("start",start);
       session.setAttribute("end",end);
//        System.out.println(start);
//        System.out.println(end);
        PhongChieuDAO451 pcd = new PhongChieuDAO451();
        List<PhongChieu451> dsPhongTrong = pcd.layPhongTrong(start, end);
//        System.out.println(dsPhongTrong.get(0).getMoTa());
        session.setAttribute("dsPhongTrong",dsPhongTrong);
//        System.out.println("okkkk: ");
//        System.out.println(session.getAttribute("dsPhongTrong"));
        request.setAttribute("listPhongTrong",dsPhongTrong);
        request.getRequestDispatcher("gdnhanvienql/GDChonThoiGian451.jsp").forward(request, response);
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String rpos = request.getParameter("viTri");
        HttpSession session = request.getSession();
        if(rpos!=null){
//            System.out.println("pos:  "+rpos);
            List<PhongChieu451> ls = (List<PhongChieu451>) session.getAttribute("dsPhongTrong");
            int pos = 0;
            try{
                pos = Integer.parseInt(rpos);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            PhongChieu451 p = ls.get(pos-1);
//            System.out.println("lss: "+ls);
            session.setAttribute("phongDuocChon", p);
        }
        PhimDAO451 pd = new PhimDAO451();
        List<Phim451> dsPhimDangChieu = pd.layPhimDangChieu();
        session.setAttribute("dsPhimDangChieu", dsPhimDangChieu);
        request.setAttribute("listPhimDangChieu",dsPhimDangChieu);
        request.getRequestDispatcher("gdnhanvienql/GDChonPhim451.jsp").forward(request, response);
    }
}
