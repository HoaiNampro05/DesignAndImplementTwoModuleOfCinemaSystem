<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Phim451, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        
        h1 {
            text-align: center;
            color: #333;
        }
        
        form {
            margin: 0 auto;
            width: 400px;
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
        }
        
        label {
            display: block;
            margin-bottom: 10px;
        }
        
        input[type="text"],
        textarea {
            width: 100%;
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="number"],
        textarea {
            width: 100%;
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="file"] {
            display: block;
            margin-top: 5px;
        }
        
        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
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
                width: 500px;
                text-align: center;
            }
            .modal-button {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }
    </style>
</head>
<body>
    <h1>Thêm phim vào danh sách đang chiếu</h1>
    <br>
    <form action="${pageContext.request.contextPath}/phim451" method="post" enctype = "multipart/form-data">
        <label for="tenPhim">Tên phim:</label>
        <input type="text" id="tenPhim" name="tenPhim"><br><br>
        
        <label for="anhMinhHoa">Ảnh minh họa:</label>
        <input type="file" id="anhMinhHoa" name="anhMinhHoa" accept="image/*"><br><br>
        
        <label for="theLoai">Thể loại:</label>
        <input type="text" id="theLoai" name="theLoai"><br><br>
        
        <label for="moTa">Mô tả:</label>
        <textarea id="moTa" name="moTa"></textarea><br><br>
        
        <label for="namPhatHanh">Năm phát hành:</label>
        <input type="number" id="namPhatHanh" name="namPhatHanh"><br><br>
       
        <input type="submit" value="Thêm">
    </form>
        <% if (request.getAttribute("phimDaThem") != null) { %>
               
            <div class="modal" id="myModal">
                <div class="modal-content">
                    <p><b>Bạn đã thêm thành công phim:</b></p>
                    <p><b>Tên:</b> ${requestScope.phimDaThem.tenPhim} </p>
                    <p> <b> Mô tả:</b>${requestScope.phimDaThem.moTa} </p>
                    <p> <b> Năm phát hành: </b>${requestScope.phimDaThem.namPhatHanh} </p>
                    <p> <b> Thể loại: </b> ${requestScope.phimDaThem.theLoai}  </p>
                    <button class="modal-button" id="okButton">OK</button>
                </div>
            </div>
        <% } %>
        
        <script>
            document.getElementById("okButton").addEventListener("click", function() {
                window.location.href = "${pageContext.request.contextPath}/phongchieu451";
            });
            window.addEventListener("load", function() {
                document.getElementById("myModal").style.display = "block";
            });
        </script>
</body>
</html>