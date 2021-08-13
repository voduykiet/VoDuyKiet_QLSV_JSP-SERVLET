<%-- 
    Document   : list_specialist
    Created on : Aug 4, 2021, 11:51:41 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý phòng khoa</title>
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
                            <h2>Danh sách phòng khoa</h2>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div style="margin-bottom: 5px">
                            <a href="them-phong-khoa"><button class="btn btn-primary">Thêm phòng khoa</button></a>
                        </div>
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã khoa</th>
                                    <th>Tên khoa</th>
                                    <th>Liên hệ</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="spe" items="${list_specialist}"> 
                                <tr>
                                    <td><%=index++%></td>
                                    <td>${spe.id_specialist}</td>
                                    <td>${spe.name_specialist}</td>
                                    <td>${spe.contact_specialist}</td>
                                    <td>
                                        <a href="hien-thi-phong-khoa?id_update=${spe.id_specialist}"<button class="btn btn-success">Sửa</button</a>
                                        <a href="danh-sach-phong-khoa?id_delete=${spe.id_specialist}"><button class="btn btn-danger">Xóa</button></a>
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
