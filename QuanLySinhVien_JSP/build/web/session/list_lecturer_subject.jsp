<%-- 
    Document   : list_lecturer_subject
    Created on : Aug 4, 2021, 12:03:19 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách giảng viên-môn học</title>
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
                            <h2>Danh sách giảng viên-môn học</h2>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div style="margin-bottom: 5px">
                            <a href="them-giang-vien-mon-hoc"><button class="btn btn-primary">Thêm giảng viên-môn học</button></a>
                        </div>
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã giảng viên</th>
                                    <th>Tên giảng viên</th>
                                    <th>Mã môn học</th>
                                    <th>Tên môn học</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="s" items="${list_lecturer_subject}">
                                <tr>

                                    <td><%=index++%></td>
                                    <td>${s.id_lecturer}</td>
                                    <td>${s.name_lecturer}</td>
                                    <td>${s.id_subject}</td>
                                    <td>${s.name_subject}</td>
                                    <td>
                                        <a href="danh-sach-giang-vien-mon-hoc?id_delete=${s.id_lecturer}-${s.id_subject}"><button class="btn btn-danger">Xóa</button></a>
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
