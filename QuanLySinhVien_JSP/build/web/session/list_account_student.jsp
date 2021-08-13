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
                            <h2>Danh sách tài khoản sinh viên</h2>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div style="margin-bottom: 5px">
                            <a href="tao-tai-khoan-sinh-vien"><button class="btn btn-primary">Thêm tài khoản</button></a>
                        </div>
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã tài khoản</th>
                                    <th>Tên tài khoản</th>
                                    <th>Mật khẩu</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="acc" items="${list_account_student}">
                                <tr>
                                    <td><%=index++%></td>
                                    <td>${acc.id_account}</td>
                                    <td>${acc.username}</td>
                                    <td>${acc.password}</td>
                                    <td>
                                        <a href="du-lieu-tai-khoan?id_update=${acc.id_account}" class="btn btn-success">Sửa</button</a>
                                        <a href="danh-sach-tai-khoan-sinh-vien?id_delete=${acc.id_account}"><button class="btn btn-danger">Xóa</button></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        
    </body>
    <!--    <script>
            function Message(id_account) {
                var annouce = confirm('Bạn có muốn xóa mã tài khoản ' + id_account);
                if (annouce === true) {
                    window.location.href = 'xoa-tai-khoan?id_delete=' + id_account;
                }
            }
        </script>-->
</html>
