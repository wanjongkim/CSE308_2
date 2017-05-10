/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.MovieManager;
import models.Movie;
import models.PlayingMovie;

/**
 *
 * @author Shawn
 */
public class MovieOverview extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movieOverview = "/JSP/movieDetails.jsp";
        //first check the nowplayingmovies
        MovieManager mm = (MovieManager) request.getServletContext().getAttribute("movieManager");
        String uri = request.getRequestURI();
        String movie = uri.substring(uri.lastIndexOf("/")+1, uri.length());
        movie = movie.replaceAll("%20", " ");
        PlayingMovie pm = mm.findMovie(movie);
        RequestDispatcher dispatcher = request.getRequestDispatcher(movieOverview);
        if(pm != null) {
            pm.setRuntime(convert(pm.getRuntime()));
            request.setAttribute("movie", pm);
            dispatcher.forward(request, response);
            return;
        }
        else {
            Movie m = mm.findMovie2(movie);
            if(m != null) {
                request.setAttribute("movie", m);
                dispatcher.forward(request, response);
                return;
            }
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    public String convert(String mins) {
        int min = Integer.parseInt(mins);
        int hours = min / 60;
        int minutes = min % 60;
        String c = "" + hours + " hours " + minutes + " minutes";
        return c;
    }
}
