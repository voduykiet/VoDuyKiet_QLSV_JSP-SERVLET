<%-- 
    Document   : category
    Created on : Aug 1, 2021, 12:18:50 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý môn học</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            int index_category = 1;
            int index_credit = 1;
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>

            <div class="container">
                <div class="panel-primary">
                    <div class="panel-heading">
                        <div class="text-center">
                            <h2>Danh sách Thể loại</h2>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div style="margin-bottom: 5px">
                            <a href="them-the-loai"><button class="btn btn-primary">Thêm thể loại</button></a>
                        </div>
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã thể loại</th>
                                    <th>Tên thể loại</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="cat" items="${list_category}">
                                <tr>
                                    <td><%=index_category++%></td>
                                    <td>${cat.id_category}</td>
                                    <td>${cat.name_category}</td>
                                    <td>
                                        <a href="hien-thi-the-loai?id_update=${cat.id_category}"<button class="btn btn-success">Sửa</button</a>
                                        <a href="danh-sach-the-loai-tin-chi?id_delete=${cat.id_category}"><button class="btn btn-danger">Xóa</button></a>
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h2>Danh sách tín chỉ</h2>
                    </div>
                </div>
                <div class="panel-body">
                    <div style="margin-bottom: 5px">
                        <a href="them-tin-chi"><button class="btn btn-primary">Thêm tín chỉ</button></a>
                    </div>
                    <table class="table table-bordered" >
                        <thead>
                            <tr>
                                <th>Số</th>
                                <th>Mã tín chỉ</th>
                                <th>Số tín chỉ</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cre" items="${list_credit}">
                                <tr>
                                    <td><%=index_credit++%></td>
                                    <td>${cre.id_credit}</td>
                                    <td>${cre.number_credit}</td>
                                    <td>
                                        <a href="hien-thi-tin-chi?id_update=${cre.id_credit}"<button class="btn btn-success">Sửa</button</a>
                                        <a href="danh-sach-the-loai-tin-chi?id_delete=${cre.id_credit}"><button class="btn btn-danger">Xóa</button></a>
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
</html>
