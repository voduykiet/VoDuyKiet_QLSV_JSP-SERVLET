<%-- 
    Document   : add_subject
    Created on : Aug 5, 2021, 11:55:24 PM
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
            String msg = (String) request.getAttribute("msg");
            String msg_1 = (String) request.getAttribute("msg_1");
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>
            <div class="container" style="width: 600px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="text-center">Thêm môn học</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label for="id_subject" >Mã môn học</label>
                                <input class="form-control" type="text" name="id_subject" placeholder="Nhập mã môn học..." id="id_subject">
                            </div>
                            <div class="form-group">
                                <label for="name_subject">Tên môn học</label>
                                <input class="form-control" type="text" name="name_subject" placeholder="Nhập tên môn học..." id="name_subject">
                            </div>
                            <div class="form-group">
                                <label for="id_credit" style="margin-right: 15px">Tín Chỉ</label>
                                <select class="form-select" id="id_credit" name="id_credit">
                                    <option disabled="" selected="">Chọn mã tín chỉ --> số tín chỉ</option>
                                <c:forEach var="cre" items="${list_credit}">
                                    <option>${cre.id_credit} --> ${cre.number_credit}</option>
                                </c:forEach>

                            </select>
                        </div>

                        <div class="form-group">
                            <label form="id_category" style="margin-right: 10px">Thể loại</label>
                            <select class="form-select" id="id_category" name="id_category">
                                <option disabled="" selected="">Chọn mã thể loại --> tên thể loại</option>
                                <c:forEach var="cat" items="${list_category}">
                                    <option>${cat.id_category} --> ${cat.name_category}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="text-danger">
                            <%=msg%>
                            <%=msg_1%>
                        </div>   
                        <button class="btn btn-success">Thêm môn học</button>                    
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
