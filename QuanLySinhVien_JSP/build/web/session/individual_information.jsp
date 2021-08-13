<%-- 
    Document   : individual_lecturer
    Created on : Aug 9, 2021, 12:06:21 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin cá nhân</title>
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
                        <h3 class="text-center">Thông tin cá nhân</h3>
                    </div>
                <c:if test="${sessionScope.account.role_sv == 1}">
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã thông tin</label>
                                <input value="${load_inf.id_student}" readonly=""class="form-control" type="text" name="id_student" placeholder="Nhập mã thông tin..." id="id_student">
                            </div>
                            <div class="form-group">
                                <label>Họ và tên</label>
                                <input value="${load_inf.fullname}"class="form-control" type="text" name="name" placeholder="Nhập họ và tên..." id="name">
                            </div>
                        </c:if>

                        <c:if test="${sessionScope.account.role_lecturer == 1}">
                            <div class="panel-body">    
                                <form method="post">
                                    <div class="form-group">
                                        <label>Mã thông tin</label>
                                        <input value="${load_inf.id_lecturer}" readonly=""class="form-control" type="text" name="id_lecturer" placeholder="Nhập mã thông tin..." id="id_lecturer">
                                    </div>
                                    <div class="form-group">
                                        <label>Họ và tên</label>
                                        <input value="${load_inf.name_lecturer}"class="form-control" type="text" name="name" placeholder="Nhập họ và tên..." id="name">
                                    </div>
                                </c:if>

                                <div class="form-group">
                                    <label>Ngày sinh</label>
                                    <input value="${load_inf.birthday}" class="form-control" name="birthday" type="date" placeholder="Nhập ngày sinh..." id="birthday">
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input  value="${load_inf.email}"class="form-control" name="email" type="email" placeholder="Nhập email..." id="email">             
                                </div>
                                <div class="form-group">
                                    <label>Số điện thoại</label>
                                    <input  value="${load_inf.phone}"class="form-control" name="phone" type="text" placeholder="Nhập số điện thoại..." id="phone">
                                </div>
                                <div class="form-group">
                                    <label>Địa chỉ</label>
                                    <input value="${load_inf.address}"class="form-control" name="address" type="text" placeholder="Nhập địa chỉ..." id="address">
                                </div>
                                <c:if test="${sessionScope.account.role_sv==1}">
                                    <div class="form-group" >
                                        <label>Lớp học</label>
                                        <select class="form-select" id="id_class" name="id_class">
                                            <option disabled="">Chọn lớp học</option>
                                            <c:forEach var="cla" items="${list_class}">
                                                <option ${(cla.id_class==load_inf.id_class)?"selected":""}>${cla.id_class} --> ${cla.name_class}</option>
                                            </c:forEach>
                                        </select>
                                    </div> 
                                </c:if>

                                <button class="btn btn-success">Cập nhật</button>                    
                            </form>
                        </div>
                </div>
            </div>

            <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>

