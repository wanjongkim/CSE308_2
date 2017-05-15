<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
        <link href="https://fonts.googleapis.com/css?family=Fjalla+One" rel="stylesheet">
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
        <jsp:useBean id="movie2" class="models.Movie" scope="session" />
        <jsp:useBean id="mt" class="models.MovieType" scope="session" />
        <jsp:useBean id="pv" class="models.PicVideo" scope="session" />
        <%@include file="header.jsp" %>
        <div class="container extra-space-top">
            <c:if test="${mt.movieType == 'pm'}">
                <div class="">
                    <h1 class="fjalla font-white">${movie.title}</h1>
                    <br>
                    <div class="row white">
                        <div class="col-sm-2 border">
                            <a class="anchor" href="../../movie/${movie.title}">OVERVIEW</a>
                        </div>
                        <div class="col-sm-3 threeBlackBorder">
                            <a class="anchor" href="">MOVIE TIMES + TICKETS</a>
                        </div>
                        <div class="col-sm-3 threeBlackBorder">
                            <a class="anchor" href="../photos/${movie.title}">PHOTOS + POSTERS</a>
                        </div>
                        <div class="col-sm-2 horizontalBlackBorder">
                            <a class="anchor" href="../casts/${movie.title}">CAST + CREW</a>
                        </div>
                        <div class="col-sm-2 border">
                            <a class="anchor" href="../reviews/${movie.title}">REVIEWS</a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3 white noSidePadding">
                        <img class="img-responsive" src="https://image.tmdb.org/t/p/w500${movie.posterPath}">
                        <h5>Homepage:
                            <c:if test="${movie.homepage != 'none'}">
                                <a class="anchor" target="_blank" href="${movie.homepage}">
                                    ${movie.homepage}
                                </a>
                            </c:if>
                            <c:if test="${movie.homepage == 'none'}">
                                <p>none</p>
                            </c:if>
                        </h5>
                        <h5>Release Date: ${movie.releaseDate}</h5>
                        <h5>Runtime: ${movie.runtime}</h5>
                        <h5>Genre: ${movie.genre.genre}</h5>
                        <i><h5>Rating: ${movie.rating}/5</h5></i>
                        <i><h5>${movie.ratedPeople} Fan Ratings</h5></i>
                    </div>
                    <div clas="col-sm-9">
                        <div id="carousel" class="carousel slide" data-ride="carousel">
                            <!-- Items -->
                            <div class="carousel-inner" style="width:auto; height:614px; max-height: 614px;">
                                <div class="item active">
                                    <c:if test="${movie.posterPath != 'none'}">
                                        <img style="height:100%; margin: 0 auto;" src="https://image.tmdb.org/t/p/w500${movie.posterPath}" alt="Slide 1" />
                                    </c:if>
                                    <c:if test="${movie.posterPath == 'none'}">
                                        <img style="height:100%; margin: 0 auto;" src="http://i.imgur.com/s0QzMrl.jpg" />
                                    </c:if>
                                </div>
                                <c:forEach var="pic" items="${pv.picList}" begin="1" end="${fn:length(pv.picList)}" varStatus = "loop">
                                    <div class="item">
                                        <img style="height:100%; min-height: 614px; width:100%; margin: 0 auto;" src="https://image.tmdb.org/t/p/w500${pic}" alt="Slide ${loop.index}" />
                                    </div>
                                </c:forEach>
                            </div> 
                            <a href="#carousel" class="right carousel-control" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </c:if> 
            <c:if test="${mt.movieType == 'm'}">
                <div class="">
                    <h1 class="fjalla font-white">${movie2.title}</h1>
                    <br>
                    <div class="row white">
                        <div class="col-sm-2 border">
                            <a class="anchor" href="../../movie/${movie2.title}">OVERVIEW</a>
                        </div>
                        <div class="col-sm-3 threeBlackBorder">
                            <a class="anchor" href="">MOVIE TIMES + TICKETS</a>
                        </div>
                        <div class="col-sm-3 threeBlackBorder">
                            <a class="anchor" href="../photos/${movie2.title}">PHOTOS + POSTERS</a>
                        </div>
                        <div class="col-sm-2 horizontalBlackBorder">
                            <a class="anchor" href="../casts/${movie2.title}">CAST + CREW</a>
                        </div>
                        <div class="col-sm-2 border">
                            <a class="anchor" href="../reviews/${movie2.title}">REVIEWS</a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3 white noSidePadding">
                        <img class="img-responsive" src="https://image.tmdb.org/t/p/w500${movie2.posterPath}">
                        <h5>Homepage:
                            <c:if test="${movie2.homepage != 'none'}">
                                <a class="anchor" target="_blank" href="${movie2.homepage}">
                                    ${movie2.homepage}
                                </a>
                            </c:if>
                            <c:if test="${movie2.homepage == 'none'}">
                                <p>none</p>
                            </c:if>
                        </h5>
                        <h5>Release Date: ${movie2.releaseDate}</h5>
                        <h5>Runtime: ${movie2.runtime}</h5>
                        <h5>Genre: ${movie2.genre.genre}</h5>
                        <i><h5>Rating: ${movie2.rating}/5</h5></i>
                        <i><h5>${movie2.ratedPeople} Fan Ratings</h5></i>
                    </div>
                    <div clas="col-sm-9">
                        <div id="carousel" class="carousel slide" data-ride="carousel">
                            <!-- Items -->
                            <div class="carousel-inner" style="width:auto; height:614px; max-height: 614px;">
                                <div class="item active">
                                    <c:if test="${movie2.posterPath != 'none'}">
                                        <img style="height:100%; margin: 0 auto;" src="https://image.tmdb.org/t/p/w500${movie2.posterPath}" alt="Slide 0" />
                                    </c:if>
                                    <c:if test="${movie2.posterPath == 'none'}">
                                        <img style="height:100%; margin: 0 auto;" src="http://i.imgur.com/s0QzMrl.jpg" />
                                    </c:if>
                                </div>
                                <c:forEach var="pic" items="${pv.picList}" begin="1" end="${fn:length(pv.picList)}" varStatus = "loop">
                                    <div class="item">
                                        <img style="height:100%; min-height: 614px; width:100%; margin: 0 auto;" src="https://image.tmdb.org/t/p/w500${pic}" alt="Slide ${loop.index}" />
                                    </div>
                                </c:forEach>
                            </div> 
                            <a href="#carousel" class="right carousel-control" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </c:if> 
            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
            <!-- Include all compiled plugins (below), or include individual files as needed --> 
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
            <script src="../../resources/js/index1.js"></script>
    </body>
</html>
