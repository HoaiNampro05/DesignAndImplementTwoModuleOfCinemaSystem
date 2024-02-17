/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.PhimDAO451;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import model.NhanVien451;
import model.Phim451;
import model.PhongChieu451;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class PhimServlet451 extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      response.sendRedirect("gdnhanvienql/GDThemPhim451.jsp");
      
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String tenPhim = request.getParameter("tenPhim"); 
        Part anhMinhHoa = request.getPart("anhMinhHoa");
        String theLoai = request.getParameter("theLoai");
        String moTa = request.getParameter("moTa");
        String namPhatHanh = request.getParameter("namPhatHanh");
        int nph =0;
        try{
            nph =  Integer.parseInt(namPhatHanh);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("namphathanh"+nph);
        Part part= request.getPart("anhMinhHoa");
        HttpSession ss = request.getSession();
        NhanVien451 nv = (NhanVien451) ss.getAttribute("user");
        Date date = new Date();
        long a = date.getTime();
        String path_img1= "C:/Users/Admin/Documents/NetBeansProjects/CineMan/web/assest/anhphim/"+"phim_"+nv.getId()+"_"+a+".jpg";
        String path_img = "C:/Users/Admin/Documents/NetBeansProjects/CineMan/web/assest/anhphim/"+"phim_"+nv.getId()+"_"+a+".jpg";
        part.write(path_img);
        String path_short = "./assest/anhphim/"+"phim_"+nv.getId()+"_"+a+".jpg";
        Phim451 phim = new Phim451(1, tenPhim, path_short, theLoai, moTa, nph, true);
        PhimDAO451 pd = new PhimDAO451();
        if(pd.themPhimDangChieu(phim)){
            request.setAttribute("phimDaThem", phim);
            request.getRequestDispatcher("gdnhanvienql/GDThemPhim451.jsp").forward(request, response);
//            response.sendRedirect("phongchieu451");
        };
    }
    public static void main(String[] args) {
        
    }
}