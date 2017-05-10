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
        <title>Sign In</title>
    </head>
    <body class="blue">
        <%@include file="header.jsp" %>
        <div class="container extra-space-top">
            <div class="center well" >
                <form class="form-horizontal" method="POST" action="login">
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="signin-username">Username</label>
                        <div class="col-sm-8">
                            <input type="text" id="signin-username" class="form-control" name="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="password">Password</label>
                        <div class="col-sm-8">
                            <input type="password" id="signin-password" class="form-control" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-5">
                            <div class="checkbox">
                                <label><input type="checkbox"> Remember me</label>
                            </div>
                        </div>
                        <div class="col-sm-offset-0 col-sm-1">
                            <button type="submit" class="btn btn-default">Log in</button>
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
