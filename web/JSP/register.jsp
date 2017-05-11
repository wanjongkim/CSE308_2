<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="resources/css/layout.css" rel="stylesheet" type="text/css">
        <link href="resources/css/colors.css" rel="stylesheet" type="text/css">
        <title>Register</title>
    </head>
    <body class="blue">
        <%@include file="header.jsp" %>
        <jsp:useBean id="err3" class="models.Error" scope="request" />
        <jsp:useBean id="temp3" class="models.TempAccountInfo" scope="request" />
        <div class="container extra-space-top">
            <div class="center well" >
                <p style="color: red">${err3.message}</p>
                <form class="form-horizontal" method="POST" action="create/account">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="signin-username">Username</label>
                        <div class="col-sm-7">
                            <input type="text" id="signup-username" class="form-control" name="username" value="${temp3.username}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="signin-firstname">First Name</label>
                        <div class="col-sm-7">
                            <input type="text" id="signup-firstname" class="form-control" name="firstName" value="${temp3.firstName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="signin-lastname">Last Name</label>
                        <div class="col-sm-7">
                            <input type="text" id="signup-lastname" class="form-control" name="lastName" value="${temp3.lastName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="signup-password">Password</label>
                        <div class="col-sm-7">
                            <input type="password" id="signup-password" class="form-control" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="signup-repassword">Confirm Password</label>
                        <div class="col-sm-7">
                            <input type="password" id="signup-repassword" class="form-control" name="repassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="signup-email">Email</label>
                        <div class="col-sm-7">
                            <input type="email" id="signup-email" class="form-control" name="email" value="${temp3.email}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-1">
                            <button type="submit" class="btn btn-default">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
