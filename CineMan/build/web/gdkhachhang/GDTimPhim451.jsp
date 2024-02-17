<%-- 
    Document   : GDTimPhim451
    Created on : Oct 16, 2023, 2:48:37 PM
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
            background-color: #f5f5f5;
        }
        table {
        border-collapse: collapse;
        width:100%;
        color: #333;
        font-family: Arial, sans-serif;
        font-size: 14px;
        text-align: left;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        margin: auto;
        margin-top: 50px;
        margin-bottom: 50px;
         }
         table th {
            background-color: #4CAF50;
            color: #fff;
            font-weight: bold;
            padding: 10px;
            text-transform: uppercase;
            letter-spacing: 1px;
            border-top: 1px solid #fff;
            border-bottom: 1px solid #ccc;
          }
          table tr:nth-child(even) td {
            background-color: #f2f2f2;
          }

          table tr:hover td {
            background-color: #ffedcc;
          }
          table td {
            background-color: #fff;
            padding: 10px;
            border-bottom: 1px solid #ccc;
            font-weight: bold;
          }
        
        input[type="text"] {
            margin-top: 10px;
            padding: 5px;
            width: 200px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
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
             opacity: 0.8;
            }

            .button:focus {
              outline: none;
            }
            .formtk{
                margin-left: 40%;
            }
            .text-input {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            color: #333;
            width: 300px;
          }
    </style>

    </head>
    <body>
          <h1 style="text-align: center">Tìm phim theo từ khóa </h1>
      <form class="formtk" action="${pageContext.request.contextPath}/khachhang451" " method="post" style="margin-bottom: 20px">
        <input type="text" name="keyword" placeholder="Nhập từ khóa" class="text-input">
        <button type="submit" class="button" style="background-color:#4CAF50">Tìm kiếm</button>
      </form>
       <% int i = 1; %>
      <% if(request.getAttribute("dsPhim")!=null){
         ArrayList<Phim451> dsPhim=(ArrayList<Phim451>)request.getAttribute("dsPhim");%>
         <h1 style="text-align: center"> Danh sách các phim theo từ khóa <b style="color:red">"${requestScope.tuKhoa}"<b> : </h1>
        <table>
            <tr>
                <th style="width:10%;text-align: center">STT</th>
                <th  style="width:35%;text-align: center">Tên phim</th>
                <th  style="width:35%;text-align: center">Năm phát hành</th>
                <th style="width:20%;text-align: center">Chọn</th>
            </tr>
            <% for (Phim451 phim : dsPhim) { %>
                <tr>
                    <td style="text-align: center"><%= i %></td>  
                    <td style="text-align: center"><%= phim.getTenPhim() %></td>
                     <td style="text-align: center"><%= phim.getNamPhatHanh() %></td>
                    <td style="text-align: center">
                       <button class="button" style="background-color:#4CAF50;float:left" onclick="location.href='${pageContext.request.contextPath}/khachhang451?viTri=<%=i%>'">Xem chi tiết</button>
                       <% if(phim.getTrangThai()){ %>
                    <input type="button" value ="Mua vé" class="button">
                    <%}%>
                    
                    </td>
                    <% i+=1; %>
                    
                </tr>
            <% } %>
        </table>
      <%}%>
    </body>
</html>
