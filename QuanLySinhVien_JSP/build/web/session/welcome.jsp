<%-- 
    Document   : welcome
    Created on : Jul 28, 2021, 8:32:33 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Trang Chủ</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>     
    </head>
    <body>
        <jsp:include page="/layout/header.jsp"></jsp:include>
            <div class="container-fluid text-center">    
                <div class="row content">
                    <div class="col-sm-2 sidenav">
                        <p><b>-Chào mừng bạn đến với trang quản lý</b></p>
                        <p><b>-Nếu bạn đăng nhập không được hãy liên hệ với bên quản lý</b></p>
                        <p><b>-Để dễ dàng sử dụng thì các chức năng sẽ hiển thị ở phía trên</b></p>
                        <p><b>-Thông tin liên hệ quanlysinhvien@gmail.com</b></p>
                    </div>
                    <div class="col-sm-8 text-left"> 
                        <img src="http://trungcapphuongnam.edu.vn/wp-content/uploads/2020/12/phan-mem-quan-ly-diem-thi.png" style="width: 900px">
                    </div>
                    <div class="col-sm-2 sidenav">
                        <p><b>Các thông báo mới nhất sẽ hiển thị ở đây</b></p>
                    </div>
                </div>
            </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
