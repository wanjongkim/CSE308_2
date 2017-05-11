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
        <link href="https://fonts.googleapis.com/css?family=Bitter:700" rel="stylesheet">
        <link href="resources/css/fonts.css" rel="stylesheet" type="text/css">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>
    <body class="blue">
        <%@include file="header.jsp" %>
        <div class="container extra-space-top">
            <!--
            <div id="main-carousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <a href="#"><img class="d-block img-fluid" src="resources/images/captain_marvel.jpg" alt="First slide"></a>
                    </div>
                    <div class="carousel-item">
                        <a href="#"><img class="d-block img-fluid" src="resources/images/fate_of_the_furious.jpg" alt="Second slide"></a>
                    </div>
                    <div class="carousel-item">
                        <a href="#"><img class="d-block img-fluid" src="resources/images/heroes_of_the_galaxy.jpg" alt="Third slide"></a>
                    </div>
                </div>
            </div>
            -->
            <div id="carousel" class="carousel slide" data-ride="carousel">
                <!-- Menu -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel" data-slide-to="1"></li>
                    <li data-target="#carousel" data-slide-to="2"></li>
                </ol>

                <!-- Items -->
                <div class="carousel-inner">

                    <div class="item active">
                        <img src="resources/images/captain_marvel.jpg" alt="Slide 1" />
                    </div>
                    <div class="item">
                        <img src="resources/images/fate_of_the_furious.jpg" alt="Slide 2" />
                    </div>
                    <div class="item">
                        <img src="resources/images/heroes_of_the_galaxy.jpg" alt="Slide 3" />
                    </div>
                </div> 
                <a href="#carousel" class="left carousel-control" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a href="#carousel" class="right carousel-control" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
            <br>
            <div class="row">
                <h1 class="raleway">Now Playing</h1>
                <hr>
            </div>

            <c:forEach begin="1" end="2" varStatus="loop">
                <c:if test="${loop.index == 1}">
                    <div class="row">
                        <c:forEach var="movie" items="${playingMovies}" begin="1" end="4">
                            <div class="col-xs-3">
                                <a href="movie/${movie.title}"><img class="img-responsive" src="https://image.tmdb.org/t/p/w500/${movie.posterPath}" alt="Missing Poster" ></a>
                            </div>
                        </c:forEach>
                    </div>
                    <br><br>
                </c:if>
                <c:if test="${loop.index == 2}">
                    <div class="row">
                        <c:forEach var="movie" items="${playingMovies}" begin="5" end="8">
                            <div class="col-xs-3">
                                <a href="movie/${movie.title}"><img class="img-responsive" src="https://image.tmdb.org/t/p/w500/${movie.posterPath}" alt="Missing Poster" ></a>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>

            </c:forEach>

        </div>

        <div class="footer">

        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed --> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
