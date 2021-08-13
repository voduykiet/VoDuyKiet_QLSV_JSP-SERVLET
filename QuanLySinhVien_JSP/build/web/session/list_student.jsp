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
            int index = 1;
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>    
            <div class="container">
                <div class="panel-primary">
                    <div class="panel-heading">
                        <div class="text-center">
                            <h2>Danh sách sinh viên</h2>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div style="margin-bottom: 5px">
                            <a href="them-sinh-vien"><button class="btn btn-primary">Thêm sinh viên</button></a>
                        </div>
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã sinh viên</th>
                                    <th>Họ và tên</th>
                                    <th>Ngày sinh</th>
                                    <th>Email</th>
                                    <th>Số điện thoại</th>
                                    <th>Địa chỉ</th>
                                    <th>Lớp</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="stu" items="${list_student}">
                                <tr>
                                    <td><%=index++%></td>
                                    <td>${stu.id_student}</td>
                                    <td>${stu.fullname}</td>
                                    <td>${stu.birthday}</td>
                                    <td>${stu.email}</td>
                                    <td>${stu.phone}</td>
                                    <td>${stu.address}</td>
                                    <td>${stu.id_class}</td>
                                    <td>
                                        <a href="hien-thi-sinh-vien?id_update=${stu.id_student}"<button class="btn btn-success">Sửa</button</a>
                                        <a href="danh-sach-sinh-vien?id_delete=${stu.id_student}"><button class="btn btn-danger">Xóa</button></a>
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
