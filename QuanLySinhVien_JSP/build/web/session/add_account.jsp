<%-- 
    Document   : account
    Created on : Jul 30, 2021, 9:38:14 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản Lý Tài Khoản</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("msg");
            String msg_1 = (String) request.getAttribute("msg_1");
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>    
        <div class="container" style="width: 600px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        Tạo tài khoản mới
                    </div>
                    <div class="panel-body">
                        <form method="post">
                            <div class="form-group">
                                <label>Mã tài khoản</label>
                                <input name="id_account" type="text" placeholder="Nhập mã tài khoản..." class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Tên tài khoản</label>
                                <input name="username" type="text" placeholder="Nhập tên tài khoản..." class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu</label>
                                <input name="password" type="password" placeholder="Nhập mật khẩu..." class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu xác nhận</label>
                                <input name="confirm_password" type="password" placeholder="Nhập lại mật khẩu..." class="form-control">
                            </div>
                            <div class="text-danger">
                            <%=msg%>
                            <%=msg_1%>
                        </div>
                        <br>
                        <button class="btn btn-primary">Thêm tài khoản</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
