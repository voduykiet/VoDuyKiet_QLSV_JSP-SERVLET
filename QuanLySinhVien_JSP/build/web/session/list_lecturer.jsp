<%-- 
    Document   : giangvien
    Created on : Jul 31, 2021, 9:54:03 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý giảng viên</title>
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
                            <h2>Danh sách giảng viên</h2>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div style="margin-bottom: 5px">
                            <a href="them-giang-vien"><button class="btn btn-primary">Thêm giảng viên</button></a>
                        </div>
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã giảng viên</th>
                                    <th>Họ và tên</th>
                                    <th>Ngày sinh</th>
                                    <th>Email</th>
                                    <th>Số điện thoại</th>
                                    <th>Địa chỉ</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="acc" items="${list_lecturer}">
                                <tr>
                                    <td><%=index++%></td>
                                    <td>${acc.id_lecturer}</td>
                                    <td>${acc.name_lecturer}</td>
                                    <td>${acc.birthday}</td>
                                    <td>${acc.email}</td>
                                    <td>${acc.phone}</td>
                                    <td>${acc.address}</td>
                                    <td>
                                        <a href="hien-thi-giang-vien?id_update=${acc.id_lecturer}"<button class="btn btn-success">Sửa</button</a>
                                        <a href="danh-sach-giang-vien?id_delete=${acc.id_lecturer}"><button class="btn btn-danger">Xóa</button></a>
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
