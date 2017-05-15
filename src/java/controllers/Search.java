/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.MovieManager;
import models.Movie;
import models.SearchResult;

/**
 *
 * @author Shawn
 */
public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchQuery = request.getParameter("q").trim();
        String capitalizedSQ = searchQuery.toUpperCase();
        //find movie by titlename
        MovieManager mm = (MovieManager) request.getServletContext().getAttribute("movieManager");
        List<Movie> l = mm.searchMovie(searchQuery);
        int numMovies = l.size();
        for(Movie m : l) {
            String runtime = m.getRuntime();
            String converted = "";
            if(!runtime.equalsIgnoreCase("unknown")) {
                converted = convert(runtime);
            }
            m.setRuntime(converted);
        }
        SearchResult sr = new SearchResult(l, numMovies, capitalizedSQ);
        request.setAttribute("search", sr);
        RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/searchPage.jsp");
        dispatcher.forward(request, response);
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
