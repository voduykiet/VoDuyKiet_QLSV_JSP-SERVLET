<%-- 
    Document   : login
    Created on : Jul 28, 2021, 5:12:12 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("msg");
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>
        <div class="container" style="width: 600px">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="text-center">Đăng nhập tài khoản</h3>
                </div>
                <div class="panel-body">    
                    <form method="post">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input class="form-control" name="username" type="text" placeholder="Enter Username..." id="username">             
                        </div>
                        <div class="form-group"> 
                            <label for="password">Password</label>
                            <input class="form-control" name="password" type="password" placeholder="Enter Password..." id="password">
                        </div>
                        <div class="text-danger">
                            <%=msg%>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-primary">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
