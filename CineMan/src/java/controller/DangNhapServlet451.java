/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.ThanhVienDAO451;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.KhachHang451;
import model.NhanVien451;

/**
 *
 * @author Admin
 */
public class DangNhapServlet451 extends HttpServlet {
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        ThanhVienDAO451 tvd = new ThanhVienDAO451();
        if(tvd.layKhachHang(username, password)!=null){
            KhachHang451 kh = tvd.layKhachHang(username, password);
            session.setAttribute("user", kh);
            response.sendRedirect("gdkhachhang/GDChinhKhachHang451.jsp");
        }
        if(tvd.layNhanVien(username, password)!=null){
            NhanVien451 nv = tvd.layNhanVien(username, password);
            session.setAttribute("user", nv);
            if(nv.getViTri().equals("ql")){
                response.sendRedirect("gdnhanvienql/GDChinhNVQL451.jsp");
            }
        }
    }

 
}
