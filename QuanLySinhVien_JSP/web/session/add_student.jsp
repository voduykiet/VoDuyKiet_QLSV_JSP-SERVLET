<%-- 
    Document   : register
    Created on : Jul 28, 2021, 4:37:24 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin sinh viên</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("msg");
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>
            <div class="container" style="width: 600px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="text-center">Đăng ký thông tin sinh viên</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã sinh viên</label>
                                <input class="form-control" type="text" name="id_student" placeholder="Nhập mã sinh viên..." id="id_student">
                            </div>
                            <div class="form-group">
                                <label>Họ và tên</label>
                                <input class="form-control" type="text" name="fullname" placeholder="Nhập họ và tên..." id="name">
                            </div>
                            <div class="form-group"> 
                                <label>Ngày sinh</label>
                                <input class="form-control" name="birthday" type="date" placeholder="Nhập ngày sinh..." id="birthday">
                            </div>
                            <div class="form-group">
                                <input class="form-control" name="email" type="email" placeholder="Nhập email..." id="email">             
                            </div>
                            <div class="form-group"> 
                                <label>Số điện thoại</label>
                                <input class="form-control" name="phone" type="text" placeholder="Nhập số điện thoại..." id="phone">
                            </div>
                            <div class="form-group">
                                <label>Địa chỉ</label>
                                <input class="form-control" name="address" type="text" placeholder="Nhập địa chỉ..." id="address">
                            </div>
                            <div class="form-group">
                                <label>Lớp học</label>
                                <select class="form-select" id="id_class" name="id_class">
                                    <option disabled="">Chọn lớp học</option>
                                <c:forEach var="cla" items="${list_class}">
                                    <option>${cla.id_class}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="text-danger">
                            <%=msg%>
                        </div>   
                        <button class="btn btn-success">Thêm sinh viên</button>                    
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
