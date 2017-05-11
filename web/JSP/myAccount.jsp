<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>InDango</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="resources/css/layout.css" rel="stylesheet" type="text/css">
        <link href="resources/css/colors.css" rel="stylesheet" type="text/css">
        <link href="resources/css/fonts.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Fjalla+One" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>
    <body class="blue">
        <%@include file="header.jsp" %>
        <jsp:useBean id="err" class="models.Error" scope="request" />
        <div class="container extra-space-top">
            <div class="well well-sm">
                <h1 class="fjalla">ACCOUNT INFORMATION</h1>
                <hr>
                <p style="color:red">${err.message}</p>
                <form class="form-horizontal" method="POST" action="update">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="username">Username</label>
                        <div class="col-sm-7">
                            <input type="text" id="info-username" class="form-control" name="username" value="${user.username}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="password">Password</label>
                        <div class="col-sm-7">
                            <input type="password" id="info-password" class="form-control" name="password" value="">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="firstName">First Name</label>
                        <div class="col-sm-7">
                            <input type="text" id="info-firstname" class="form-control" name="firstname" value="${user.firstName}">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="username">Last name</label>
                        <div class="col-sm-7">
                            <input type="text" id="info-lastname" class="form-control" name="lastname" value="${user.lastName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Email</label>
                        <div class="col-sm-7">
                            <input type="text" id="info-email" class="form-control" name="email" value="${user.email}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-1">
                            <button type="submit" class="btn btn-default">Update</button>
                        </div>
                    </div>
                </form>
            </div>
            <!-- let the person change some information -->
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed --> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
