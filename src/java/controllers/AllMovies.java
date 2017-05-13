/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.MovieManager;
import models.AllMovieList;
import models.Movie;

/**
 *
 * @author Shawn
 */
public class AllMovies extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageNum = request.getQueryString();
        int equal = pageNum.indexOf("page=");
        if(equal == -1) {
            return;
        }
        else {
            equal = equal + 4;
        }
        pageNum = pageNum.substring(equal+1, pageNum.length());
        int pageNumI = Integer.parseInt(pageNum);
        int index = pageNumI * 60;
        MovieManager mm = (MovieManager) request.getServletContext().getAttribute("movieManager");
        List<Movie> l = mm.getAllMovies();
        List newL = new ArrayList();
        int pageLimit = l.size() % 60;
        for(int i=index; i>=index-60; i--) {
            newL.add(l.get(i));
        }
        AllMovieList aml = new AllMovieList(newL, pageLimit, pageNumI);
        request.setAttribute("aml", aml);
        RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/allMovies.jsp");
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
}
