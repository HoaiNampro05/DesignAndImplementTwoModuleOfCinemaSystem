<%-- 
    Document   : GDQuanLyLichChieu451
    Created on : Oct 23, 2023, 7:54:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-color: #f5f5f5;
            }
           .button {
                background-color: #4CAF50;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 20px;
                box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.4);
                cursor: pointer;
                margin: auto;
              }

            .button:hover {
             opacity: 0.8;
            }

            .button:focus {
              outline: none;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center">Quản lý lịch chiếu</h1>
        <div style="display:flex">
       <button class="button" onclick="location.href='/cineman/gdnhanvienql/GDChonThoiGian451.jsp'">LÊN LỊCH CHIẾU</button>
        </div>
    </body>
</html>
