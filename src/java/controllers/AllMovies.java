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
        int genreFilter = pageNum.indexOf("genreFilter=");
        int equal = pageNum.indexOf("page=");
        if(equal == -1) {
            return;
        }
        else {
            equal = equal + 4;
        }
        if(genreFilter == -1) {
            String pageNumber = pageNum.substring(equal+1, pageNum.length());
            int pageNumI = Integer.parseInt(pageNumber);
            int index = 0;
            if(pageNumI != 1) {
                index = pageNumI;
                index *= 60;
                index -= 60;
            }
            MovieManager mm = (MovieManager) request.getServletContext().getAttribute("movieManager");
            List<Movie> l = mm.getAllMovies();
            List newL = new ArrayList();
            double pageLimit = l.size() / 60;
            pageLimit = Math.ceil(pageLimit);
            if(l.size() % 60 > 0) {
                pageLimit++;
            }
            int pl = (int) pageLimit;
            for(int i=index; i<=index+60; i++) {
                if(i<l.size() && l.get(i) != null) {
                    newL.add(l.get(i));
                }
                else 
                    break;
            }
            AllMovieList aml = new AllMovieList(newL, pl, pageNumI, "all");
            request.setAttribute("aml", aml);
        }
        else {
            String pageNumber = pageNum.substring(equal+1, genreFilter-1); 
            genreFilter += 12;
            String filter = pageNum.substring(genreFilter, pageNum.length());
            int pageNumI = Integer.parseInt(pageNumber);
            int index = 0;
            if(pageNumI != 1) {
                index = pageNumI;
                index *= 60;
                index -= 60;
            }
            MovieManager mm = (MovieManager) request.getServletContext().getAttribute("movieManager");
            filter = filter.toLowerCase().trim();
            List<Movie> m = new ArrayList();
            String type = "";
            switch(filter) {
                case "comedy": {
                    m = mm.getComedy();
                    type="comedy";
                    break;
                }
                case "animation": {
                    m = mm.getAnimation();
                    type="animation";
                    break;
                }
                case "documentary": {
                    m = mm.getDocumentary();
                    type="documentary";
                    break;
                }
                case "horror": {
                    m = mm.getHorror();
                    type="horror";
                    break;
                }
                case "mystery": {
                    m = mm.getMystery();
                    type="mystery";
                    break;
                }
                case "action": {
                    m = mm.getAction();
                    type="action";
                    break;
                }
                default:
                    break;
            }
            
            List<Movie> newL = new ArrayList();
            for(int i=index; i<=index+60; i++) {
                if(i < m.size() && m.get(i) != null) {
                    newL.add(m.get(i));
                }
                else 
                    break;
            }
            double pageLimit = m.size() / 60;
            pageLimit = Math.ceil(pageLimit);
            int pl = (int) pageLimit;
            if(m.size() % 60 > 0) {
                pl++;
            }
            AllMovieList aml = new AllMovieList(newL, pl, pageNumI, type);
            request.setAttribute("aml", aml);
        }
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
