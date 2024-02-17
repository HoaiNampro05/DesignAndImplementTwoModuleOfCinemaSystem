<%-- 
    Document   : GDChonThoiGian
    Created on : Oct 23, 2023, 7:54:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.PhongChieu451, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chọn thời gian và ngày bắt đầu/kết thúc</title>
    <style>
        body{
            background-color: #f5f5f5;
        }
        table {
        border-collapse: collapse;
       
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
/*    form {
        font-family: Arial, sans-serif;
        color: #333;
        background-color: #f5f5f5;
        width: 60%;
        margin: auto;
        padding: 10px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
      }*/
.content1{
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.time-inputs {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
input[type="number"], input[type="date"] {
  width: 100%;
  height: 20px;
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 4px;
  border: none;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}
.submit-button{
    display:flex;
}
label{
    font-weight:bolder;
}
input[type="submit"] {
  background-color: #4CAF50;
  border: none;
  color: white;
  width: 120px;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  margin: auto;
  cursor: pointer;
  border-radius: 8px;
  text-align: center;
}

input[type="submit"]:hover {
  background-color: #3e8e41;
}


.submit-button input[type="submit"]:hover {
  background-color: #3e8e41;
}


</style>
    <script>
        function validateTime() {
            var startHour = parseInt(document.getElementById("start-hour").value);
            var startMinute = parseInt(document.getElementById("start-minute").value);
            var endHour = parseInt(document.getElementById("end-hour").value);
            var endMinute = parseInt(document.getElementById("end-minute").value);

            var startDate = document.getElementById("start-date").value;
            var endDate = document.getElementById("end-date").value;

            if (startHour < 0 || startHour > 23 || startMinute < 0 || startMinute > 59 ||
                endHour < 0 || endHour > 23 || endMinute < 0 || endMinute > 59) {
                alert("Vui lòng nhập thời gian hợp lệ (0-23 giờ, 0-59 phút).");
                return false;
            }

            if (startDate > endDate) {
                alert("Ngày kết thúc phải sau ngày bắt đầu.");
                return false;
            }
             if (startDate == endDate && (startHour*60+startMinute >= endHour*60+endMinute)) {
                alert("Thời gian kết thúc phải sau thời gian bắt đầu");
                return false;
            }
        }
    </script>
</head>
<body>
    <h1 style="text-align:center">Chọn thời gian cho lịch chiếu</h1>
    <form onsubmit="return validateTime()" action="${pageContext.request.contextPath}/phongchieu451" method="post">
        <div class ="content1">
        <div class="time-inputs">
            <div>
            <label for="start-hour" >Giờ bắt đầu:</label>
            <input type="number" id="start-hour" name="start-hour" min="0" max="23" required>
            </div>
            <div>
            <label for="start-minute">Phút bắt đầu:</label>
            <input type="number" id="start-minute" name="start-minute" min="0" max="59" required>
            </div>
            <div>
            <label for="start-date">Ngày bắt đầu:</label>
            <input type="date" id="start-date" name="start-date" required>
            </div>
        </div>

        <div class="time-inputs">
            <div>
            <label for="end-hour">Giờ kết thúc:</label>
            <input type="number" id="end-hour" name="end-hour" min="0" max="23" required>
            </div>
            <div>
            <label for="end-minute">Phút kết thúc:</label>
            <input type="number" id="end-minute" name="end-minute" min="0" max="59" required>
            </div>
            <div>
             <label for="end-date">Ngày kết thúc:</label>
            <input type="date" id="end-date" name="end-date" required>
            </div>
        </div>
        </div>
        <div class="submit-button" style="margin:auto">
            <input type="submit" value="TÌM PHÒNG">
        </div>
    </form>
    <% if(request.getAttribute("listPhongTrong")!=null){
         ArrayList<PhongChieu451> ds=(ArrayList<PhongChieu451>)request.getAttribute("listPhongTrong"); int i = 1;%>
         <h2 style="text-align:center">Các phòng có trong khoảng thời gian<h2>
         <h3 style="text-align: center">Từ: ${sessionScope.startHour} ${sessionScope.startDay}</h3>
         <h3 style="text-align:center">Đến: ${sessionScope.endHour} ${sessionScope.endDay}</h3>
    <table style=" width: 100%;">
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Vị trí</th>
            <th>Sức chứa</th>
            <th>Mô tả</th>
            <th>chọn</th>
        </tr>
        <% for (PhongChieu451 phong : ds) { %>
            <tr>
                <td><%= i %></td>
                <td><%= phong.getTen() %></td>
                <td><%= phong.getViTri() %></td>
                <td><%= phong.getSucChua() %></td>
                <td><%= phong.getMoTa() %></td>
                <td>
                     <form action="${pageContext.request.contextPath}/phongchieu451" method="get">
                        <input type="hidden" name="viTri" value="<%= i %>">
                        <input type="submit" value="chọn">
                    </form>
                </td>
            </tr>
            <% i+=1;%>
        <% } %>
    </table>
<% } %>
</body>
</html>