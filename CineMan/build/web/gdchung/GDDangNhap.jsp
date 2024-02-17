<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 20px;
            }
            
            form {
                max-width: 300px;
                margin: 0 auto;
                background-color: #fff;
                border-radius: 5px;
                padding: 20px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            
            label {
                display: block;
                margin-bottom: 10px;
                font-weight: bold;
                color: #333;
            }
            
            input[type="text"],
            input[type="password"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin-bottom: 20px;
                box-sizing: border-box; /* Thêm thuộc tính này */
            }
            
            input[type="submit"] {
                background-color: #4CAF50;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            
            input[type="submit"]:hover {
                background-color: #45a049;
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
        <form action="${pageContext.request.contextPath}/dangnhap451" method="POST">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" id="username" name="username" required><br><br>

            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required><br><br>

            <input type="submit" class= "button" value="ĐĂNG NHẬP">
        </form>
    </body>
</html>