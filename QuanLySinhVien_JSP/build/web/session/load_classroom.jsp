<%-- 
    Document   : load_classroom
    Created on : Aug 6, 2021, 4:46:47 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý lớp học</title>
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
                        <h3 class="text-center">Thông tin lớp học</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã lớp học</label>
                                <input value="${classroom.id_class}"class="form-control" type="text" name="id_class" placeholder="Nhập mã lớp học..." id="id_class" readonly="">
                        </div>
                        <div class="form-group">
                            <label>Tên lớp học</label>
                            <input value="${classroom.name_class}" class="form-control" type="text" name="name_class" placeholder="Nhập tên lớp học..." id="name_class">
                        </div>
                        <div class="form-group">
                            <label>Chọn phòng khoa</label>
                            <select class="form-select" id="id_specialist" name="id_specialist">
                                <option disabled="">Chọn mã khoa</option>
                                <c:forEach var="spe" items="${list_specialist}">
                                    <option ${(spe.id_specialist==classroom.id_specialist)?"selected":""}>${spe.id_specialist} --> ${spe.name_specialist}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <button class="btn btn-success">Cập nhật</button>                    
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
