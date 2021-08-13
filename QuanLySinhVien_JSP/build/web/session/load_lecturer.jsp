<%-- 
    Document   : load_lecturer
    Created on : Aug 5, 2021, 10:15:58 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật giảng viên</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="/layout/header.jsp"></jsp:include>
            <div class="container" style="width: 600px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="text-center">Cập nhật giảng viên</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã giảng viên</label>
                                <input value="${lecturer.id_lecturer}" readonly=""class="form-control" type="text" name="id_lecturer" placeholder="Nhập mã giảng viên...">
                        </div>
                        <div class="form-group">
                            <label>Họ và tên</label>
                            <input value="${lecturer.name_lecturer}"class="form-control" type="text" name="name_lecturer" placeholder="Nhập họ và tên...">
                        </div>
                        <div class="form-group"> 
                            <label>Ngày sinh</label>
                            <input value="${lecturer.birthday}" class="form-control" name="birthday" type="date" placeholder="Nhập ngày sinh...">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input  value="${lecturer.email}"class="form-control" name="email" type="email" placeholder="Nhập email..." >             
                        </div>
                        <div class="form-group"> 
                            <label>Số điện thoại</label>
                            <input  value="${lecturer.phone}"class="form-control" name="phone" type="text" placeholder="Nhập số điện thoại..." >
                        </div>
                        <div class="form-group">
                            <label>Địa chỉ</label>
                            <input value="${lecturer.address}"class="form-control" name="address" type="text" placeholder="Nhập địa chỉ...">
                        </div> 
                        <button class="btn btn-success">Cập nhật</button>  
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

