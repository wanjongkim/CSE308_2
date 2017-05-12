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
        <link href="../../resources/css/layout.css" rel="stylesheet" type="text/css">
        <link href="../../resources/css/colors.css" rel="stylesheet" type="text/css">
        <link href="../../resources/css/fonts.css" rel="stylesheet" type="text/css">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>

    <body class="blue">
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <jsp:useBean id="movie" class="models.PlayingMovie" scope="session" />
        <jsp:useBean id="pv" class="models.PicVideo" scope="session" />
        <%@include file="header.jsp" %>
        <div class="container extra-space-top">
            <div class="menu">
                <h1>${movie.title}</h1>
                <br>
                <div class="row">
                    <div class="col-xs-2">
                        <a class="anchor" href="../../movie/${movie.title}">OVERVIEW</a>
                    </div>
                    <div class="col-xs-2">
                        <a class="anchor" href="">MOVIE TIMES + TICKETS</a>
                    </div>
                    <div class="col-xs-2">
                        <a class="anchor" href="">PHOTOS + POSTERS</a>
                    </div>
                    <div class="col-xs-2">
                        <a class="anchor" href="../casts/${movie.title}">CAST + CREW</a>
                    </div>
                    <div class="col-xs-2">
                        <a class="anchor" href="../reviews/${movie.title}">REVIEWS</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="poster col-xs-4">
                    <img class="img-responsive" src="https://image.tmdb.org/t/p/w500${movie.posterPath}" alt="No Poster">
                    <h5>Homepage: <a class="anchor" target="_blank" href="${movie.homepage}">${movie.homepage}</a></h5>
                    <h5>Release Date: ${movie.releaseDate}</h5>
                    <h5>Runtime: ${movie.runtime}</h5>
                    <h5>Genre: ${movie.genre.genre}</h5>
                    <i><h5>Rating: ${movie.rating}/10</h5></i>
                    <i></h5>${movie.ratedPeople} Fan Ratings</h5></i>
                </div>
                <div class="col-xs-8">
                    <div class="row">
                        <img style="width: 400px; height: 550px;" src="https://image.tmdb.org/t/p/w500${movie.posterPath}" alt="No Poster">
                    </div>
                    <div class="row">
                        <c:forEach items="${pv.picList}" var="pic" begin="1" end="${fn:length(pv.picList)}">
                            <div class="col-xs-2">
                                <img class="img-responsive" src="https://image.tmdb.org/t/p/w500${pic}" alt="Picture Not Found">
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed --> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="../../resources/js/index1.js"></script>
    </body>
</html>
