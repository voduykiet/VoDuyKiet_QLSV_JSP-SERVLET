<%-- 
    Document   : load_specialist
    Created on : Aug 6, 2021, 4:47:01 PM
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
        <jsp:include page="/layout/header.jsp"></jsp:include>
            <div class="container" style="width: 600px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="text-center">Thông tin phòng khoa</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã phòng khoa</label>
                                <input value="${specialist.id_specialist}" class="form-control" type="text" name="id_specialist" placeholder="Nhập mã phòng khoa..." id="id_specialist" readonly="">
                            </div>
                            <div class="form-group">
                                <label>Tên phòng khoa</label>
                                <input value="${specialist.name_specialist}" class="form-control" type="text" name="name_specialist" placeholder="Nhập tên phòng khoa..." id="name_specialist">
                            </div>
                            <div class="form-group">
                                <label>Thông tin liên hệ</label>
                                <input value="${specialist.contact_specialist}" class="form-control" type="text" name="contact_specialist" placeholder="Nhập thông tin liên hệ..." id="contact_specialist">
                            </div>

                        <button class="btn btn-success">Cập nhật</button>                    
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
