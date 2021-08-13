<%-- 
    Document   : add_lecturer_subject
    Created on : Aug 7, 2021, 7:21:33 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý giảng viên-môn học</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("msg");
            String msg_1 = (String) request.getAttribute("msg_1");
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>
            <div class="container" style="width: 600px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="text-center">Thêm giảng viên-môn học</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label for="id_lecturer" style="margin-right: 10px">Giảng viên</label>
                                <select class="form-select" id="id_lecturer" name="id_lecturer" style="width: 350px">
                                    <option selected="" disabled="" >Chọn mã giảng viên --> tên giảng viên</option>
                                <c:forEach var="lec" items="${list_lecturer}">
                                    <option>${lec.id_lecturer} --> ${lec.name_lecturer}</option>
                                    </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="id_subject" style="margin-right: 25px">Môn học</label>
                            <select class="form-select" id="id_subject" name="id_subject" style="width: 350px">
                                <option selected="">Chọn mã môn học --> tên môn học</option>
                                <c:forEach var="sub" items="${list_subject}">
                                    <option>${sub.id_subject} --> ${sub.name_subject}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="text-danger">
                            <%=msg%>
                            <%=msg_1%>
                        </div>   
                        <button class="btn btn-success">Thêm giảng viên-môn học</button>                    
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>