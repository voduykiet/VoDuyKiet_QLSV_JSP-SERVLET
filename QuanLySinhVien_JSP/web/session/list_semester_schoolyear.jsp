<%-- 
    Document   : list_semester_schoolyear
    Created on : Aug 7, 2021, 12:18:51 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý học kì-năm học</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            int index_semester = 1;
            int index_schoolyear = 1;
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>

            <div class="container">
                <div class="panel-primary">
                    <div class="panel-heading">
                        <div class="text-center">
                            <h2>Danh sách học kì</h2>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div style="margin-bottom: 5px">
                            <a href="them-hoc-ki"><button class="btn btn-primary">Thêm học kì</button></a>
                        </div>
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã học kì</th>
                                    <th>Tên học kì</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="se" items="${list_semester}">
                                <tr>
                                    <td><%=index_semester++%></td>
                                    <td>${se.id_semester}</td>
                                    <td>${se.name_semester}</td>
                                    <td>
                                        <a href="hien-thi-hoc-ki?id_update=${se.id_semester}"<button class="btn btn-success">Sửa</button</a>
                                        <a href="danh-sach-hoc-ki-nam-hoc?id_delete=${se.id_semester}"><button class="btn btn-danger">Xóa</button></a>
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
                        <h2>Danh sách năm học</h2>
                    </div>
                </div>
                <div class="panel-body">
                    <div style="margin-bottom: 5px">
                        <a href="them-nam-hoc"><button class="btn btn-primary">Thêm năm học</button></a>
                    </div>
                    <table class="table table-bordered" >
                        <thead>
                            <tr>
                                <th>Số</th>
                                <th>Mã năm học</th>
                                <th>Tên năm học</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="sc" items="${list_school_year}">
                                <tr>
                                    <td><%=index_schoolyear++%></td>
                                    <td>${sc.id_school_year}</td>
                                    <td>${sc.name_school_year}</td>
                                    <td>
                                        <a href="hien-thi-nam-hoc?id_update=${sc.id_school_year}"<button class="btn btn-success">Sửa</button</a>
                                        <a href="danh-sach-hoc-ki-nam-hoc?id_delete=${sc.id_school_year}"><button class="btn btn-danger">Xóa</button></a>
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
