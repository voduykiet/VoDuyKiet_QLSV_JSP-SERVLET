<%-- 
    Document   : add_individual_score_student
    Created on : Aug 9, 2021, 11:51:35 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Điểm sinh viên</title>
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
                        <h3 class="text-center">Thêm điểm sinh viên</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã điểm</label>
                                <input class="form-control" type="text" name="id_score" placeholder="Nhập mã điểm..." id="id_score">
                            </div>

                            <div class="form-group">
                                <label>Điểm hệ 1(10%)</label>
                                <input class="form-control" type="text" name="score_1" placeholder="Nhập điểm hệ 1..." id="score_1">
                            </div>  

                            <div class="form-group">
                                <label>Điểm hệ 4(40%)</label>
                                <input class="form-control" type="text" name="score_4" placeholder="Nhập điểm hệ 4..." id="score_4">
                            </div>  

                            <div class="form-group">
                                <label>Điểm thi(50%)</label>
                                <input class="form-control" type="text" name="score_test" placeholder="Nhập điểm thi..." id="score_test">
                            </div>  

                            <div class="form-group">
                                <label>Điểm trung bình</label>
                                <input class="form-control" type="text" name="avg_score" placeholder="Nhập điểm trung bình..." id="avg_score">
                            </div> 


                            <div class="form-group">
                                <label for="id_student" style="margin-right: 20px">Sinh viên</label>
                                <select class="form-select" id="id_student" name="id_student" style="width: 350px">
                                    <option selected="" disabled="" >Chọn mã sinh viên --> tên sinh viên</option>
                                <c:forEach var="stu" items="${list_student}">
                                    <option>${stu.id_student} --> ${stu.fullname}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="id_subject" style="margin-right: 25px">Môn học</label>
                            <select class="form-select" id="id_subject" name="id_subject" style="width: 350px">
                                <option selected="" disabled="">Chọn mã môn học --> tên môn học</option>
                                <c:forEach var="sub" items="${list_subject}">
                                    <option>${sub.id_subject} --> ${sub.name_subject}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="id_credit" style="margin-right: 35px">Tín chỉ</label>
                            <select class="form-select" id="id_credit" name="id_credit" style="width: 350px">
                                <option selected="" disabled="">Chọn mã tín chỉ --> số tín chỉ</option>
                                <c:forEach var="cre" items="${list_credit}">
                                    <option>${cre.id_credit} --> ${cre.number_credit}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="id_category" style="margin-right: 30px">Thể loại</label>
                            <select class="form-select" id="id_category" name="id_category" style="width: 350px">
                                <option selected="" disabled="">Chọn mã thể loại --> tên thể loại</option>
                                <c:forEach var="cat" items="${list_category}">
                                    <option>${cat.id_category} --> ${cat.name_category}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="id_semester" style="margin-right: 40px">Học kì</label>
                            <select class="form-select" id="id_semester" name="id_semester" style="width: 350px">
                                <option selected="" disabled="">Chọn mã học kì --> tên học kì</option>
                                <c:forEach var="sem" items="${list_semester}">
                                    <option>${sem.id_semester} --> ${sem.name_semester}</option>
                                </c:forEach>
                            </select>
                        </div> 

                        <div class="form-group">
                            <label for="id_school_year" style="margin-right: 20px">Năm học</label>
                            <select class="form-select" id="id_school_year" name="id_school_year" style="width: 350px">
                                <option selected="" disabled="">Chọn mã năm học --> tên năm học</option>
                                <c:forEach var="sch" items="${list_school_year}">
                                    <option>${sch.id_school_year} --> ${sch.name_school_year}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="text-danger">
                            <%=msg%>
                            <%=msg_1%>
                        </div>   
                        <button class="btn btn-success">Thêm điểm sinh viên</button>                    
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
