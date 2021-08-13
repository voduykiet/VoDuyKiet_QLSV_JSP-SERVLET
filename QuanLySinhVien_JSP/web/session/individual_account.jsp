<%-- 
    Document   : individual_account_lecturer
    Created on : Aug 9, 2021, 12:05:57 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin tài khoản</title>
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
                        <h3 class="text-center">Thông tin tài khoản</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã tài khoản</label>
                                <input  value="${account_load.id_account}"class="form-control" type="text" name="id_account" placeholder="Nhập mã tài khoản..." id="id_account" readonly="">
                        </div>
                        <div class="form-group">
                            <label>Tên tài khoản</label>
                            <input value="${account_load.username}"class="form-control" type="text" name="username" placeholder="Nhập tên tài khoản..." id="username">
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu</label>
                            <input value="${account_load.password}"class="form-control" name="password" type="text" placeholder="Nhập mật khẩu..." id="password">
                        </div>

                        <button class="btn btn-success">Cập nhật</button>                    
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
