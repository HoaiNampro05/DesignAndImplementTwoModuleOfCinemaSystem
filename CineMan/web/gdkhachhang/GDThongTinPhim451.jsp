<%-- 
    Document   : GDThongTinPhim451
    Created on : Oct 16, 2023, 2:48:49 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Phim451, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-color: #111;
            }
            h1 {
                text-align: center;
                color: #333;
            }

            h3 {
                color: #fff;
                margin-bottom: 10px;
            }

            p {
                color: #fff;
                margin-bottom: 10px;
                margin-left: 30%;
            }
            .button {
                background-color: #007bff;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 20px;
                box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.4);
                cursor: pointer;
                margin: auto;
            }

            .button:hover {
                background-color: #0056b3;
            }

            .button:focus {
                outline: none;
            }
            .phim {
                width:50%;
                margin: auto;
                background-color: #333;
                display: flex;
                flex-direction: column;
                align-items: flex-start;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
            }

            .phim h3,
            .phim p {
                margin: 0;
            }

            .phim img {
                width: 100%;
                max-width: 300px;
                height: auto;
                margin: 10px 0;
            }

            .phim .button {
                background-color: #007bff;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 20px;
                box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.4);
                cursor: pointer;
                align-self: flex-end;
            }

            .phim .button:hover {
                background-color: #0056b3;
            }

            .phim .button:focus {
                outline: none;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center;color: white">Thông tin chi tiết của phim</h1>
        <div class="phim">
            <% if(request.getAttribute("phim") != null) { 
         Phim451 phim = (Phim451) request.getAttribute("phim"); %>
            <% boolean d = phim.getTrangThai() ;%>
            <h3 style="text-align: center;color:gold">Tên phim: ${requestScope.phim.tenPhim}</h3>
            <div style="display:flex;justify-content: space-around">
                <div style="display: flex; justify-content: center; align-items: center;">
                    <img src="${requestScope.phim.anhMinhHoa}" style="width:400px; height:300px;border-radius: 20px">
                </div>
                <div style="padding-top:30px;padding-left: 20px">
                    <p><b style="color:goldenrod">Thể loại:</b> ${requestScope.phim.theLoai}<p>
                        <br>
                    <p> <b style="color:goldenrod"> Mô tả: </b> ${requestScope.phim.moTa}</p>
                    <br>
                    <p> <b style="color:goldenrod"> Năm phát hành:</b> ${requestScope.phim.namPhatHanh}</p>
                </div>
            </div>
            <div style="display:flex">
                <% if(d) { %>
                <input type="button" value ="Mua vé" class="button">
                <% } %>
            </div>
            <% } %>
        </div>
    </body>
</html>