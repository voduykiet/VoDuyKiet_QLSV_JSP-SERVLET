<%-- 
    Document   : add_specialist
    Created on : Aug 6, 2021, 4:46:32 PM
    Author     : DELL
--%>

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
            String msg = (String) request.getAttribute("msg");
            String msg_1 = (String) request.getAttribute("msg_1");
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>
            <div class="container" style="width: 600px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="text-center">Thêm phòng khoa</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã phòng khoa</label>
                                <input class="form-control" type="text" name="id_specialist" placeholder="Nhập mã phòng khoa..." id="id_specialist">
                            </div>
                            <div class="form-group">
                                <label>Tên phòng khoa</label>
                                <input class="form-control" type="text" name="name_specialist" placeholder="Nhập tên phòng khoa..." id="name_specialist">
                            </div>
                            <div class="form-group">
                                <label>Thông tin liên hệ</label>
                                <input class="form-control" type="text" name="contact_specialist" placeholder="Nhập thông tin liên hệ..." id="contact_specialist">
                            </div>

                            <div class="text-danger">
                            <%=msg%>
                            <%=msg_1%>
                        </div>   
                        <button class="btn btn-success">Thêm phòng khoa</button>                    
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
