<%-- 
    Document   : GDChonPhim451
    Created on : Oct 23, 2023, 7:55:01 PM
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
        .formbang{
            width: 100%;
        }
        .tb{
            width:100%;
        }
        input[type="submit"] {
            float:right;
            background-color: #4CAF50;
            border: none;
            color: white;
            width: 120px;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin-bottom: 10px;
            cursor: pointer;
            border-radius: 8px;
            text-align: center;
          }

          input[type="submit"]:hover {
            background-color: #3e8e41;
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
          .xn{ 
          display:flex;
          }
          .xn1{
              width:120px;
              margin:auto;
          }

              .alert {
                  background-color: #f8d7da;
                  color: #721c24;
                  padding: 10px;
                  border: 1px solid #f5c6cb;
                  border-radius: 4px;
                  margin-bottom: 10px;
              }

             .message {
                  display: block;
                  margin-bottom: 10px;
             }
                .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0, 0, 0, 0.5);
            }
            .modal-content {
                background-color: white;
                margin: 20% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 300px;
                text-align: center;
            }
            .modal-button {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }
            .button {
                background-color: #4CAF50;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 10px;
                box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.4);
                cursor: pointer;
                margin-bottom: 10px;
                float:right;
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
        <h1 style="text-align: center">Chọn phim cho lịch chiếu</h1>
        <h3 style="text-align: center">Giờ bắt đầu: ${sessionScope.startHour} ${sessionScope.startDay}</h3>
        <h3 style="text-align: center">Giờ kết thúc: ${sessionScope.endHour} ${sessionScope.endDay}</h3>
        <h3 style="text-align: center">Phòng: ${sessionScope.phongDuocChon.ten}</h3>
        <button class="button" onclick="location.href='/cineman/gdnhanvienql/GDThemPhim451.jsp'">Thêm phim</button>
        <% int i = 1; %>
         <% if(request.getAttribute("listPhimDangChieu")!=null){
         ArrayList<Phim451> dsPhim=(ArrayList<Phim451>)request.getAttribute("listPhimDangChieu");%>
         <form action="${pageContext.request.contextPath}/lichchieu451" method="post" class="formbang">
             <div class="tb">
            <table>
                <tr>
                    <th>STT</th>
                    <th>Tên phim</th>
                    <th>Mô tả</th>
                    <th>Năm phát hành</th>
                    <th>Chọn</th>
                </tr>
                <% for (Phim451 phim : dsPhim) { %>
                    <tr>
                        <td><%= i %></td> 
                       
                        <td><%= phim.getTenPhim() %></td>
                        <td><%= phim.getMoTa() %></td>
                        <td><%= phim.getNamPhatHanh() %></td>
                        
                        <td>
                            <input type="radio" name="selectedPhimId" value="<%= phim.getId() %>">
                        </td>
                    </tr>
                    <% i+=1; %>
                <% } %>
            </table>
             </div>
            <div class="xn">
             <input type="submit" value="XÁC NHẬN" class="xn1">
            </div>
        </form>
         <%}%>
         
       
        <% if (request.getAttribute("message") != null) { %>
            <div class="modal" id="myModal">
                <div class="modal-content">
                    <p><b>${requestScope.message}</b></p>
                    <p><b>Giờ bắt đầu:</b> ${sessionScope.startHour} ${sessionScope.startDay} </p>
                    <p> <b> Giờ kết thúc:</b> ${sessionScope.endHour} ${sessionScope.endDay} </p>
                    <p> <b> Phòng: </b>${sessionScope.phongDuocChon.ten} </p>
                    <p> <b> Phim: </b> ${requestScope.phim1.tenPhim}  </p>
                    <button class="modal-button" id="okButton">OK</button>
                </div>
            </div>
        <% } %>
        
        <script>
            document.getElementById("okButton").addEventListener("click", function() {
                window.location.href = "gdnhanvienql/GDChinhNVQL451.jsp";
            });
            window.addEventListener("load", function() {
                document.getElementById("myModal").style.display = "block";
            });
        </script>
    </body>
</html>
