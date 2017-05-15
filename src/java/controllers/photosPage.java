/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.MovieManager;
import models.Movie;
import models.MovieType;
import models.PicVideo;
import models.PlayingMovie;

/**
 *
 * @author Shawn
 */
public class photosPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String photosPage = "../../JSP/photos.jsp";
        //first check the nowplayingmovies
        MovieManager mm = (MovieManager) request.getServletContext().getAttribute("movieManager");
        String uri = request.getRequestURI();
        String movie = uri.substring(uri.lastIndexOf("/")+1, uri.length());
        movie = movie.replaceAll("%20", " ");
        PlayingMovie pm = mm.findMovie(movie);
        HttpSession sess = request.getSession();
        if(pm != null) {
            if(!pm.getRuntime().equalsIgnoreCase("unknown")) {
                pm.setRuntime(convert(pm.getRuntime()));
            }
            sess.setAttribute("movie", pm);
            String pics = pm.getPicture();
            ArrayList converted = convertPicString(pics);
            PicVideo pv = new PicVideo(converted);
            sess.setAttribute("pv", pv);
            MovieType mt = new MovieType("pm");
            sess.setAttribute("mt", mt);
        }
        else {
            Movie m = mm.findMovie2(movie);
            if(m != null) {
                if(!m.getRuntime().equalsIgnoreCase("unknown")) {
                    m.setRuntime(convert(m.getRuntime()));
                }
                sess.setAttribute("movie2", m);
                String pics = m.getImage();
                ArrayList converted = convertPicString(pics);
                PicVideo pv = new PicVideo(converted);
                sess.setAttribute("pv", pv);
                MovieType mt = new MovieType("m");
                sess.setAttribute("mt", mt);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(photosPage);
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
    
    public ArrayList convertPicString(String picPaths) {
        ArrayList li = new ArrayList();
        if(picPaths.equalsIgnoreCase("none")) {
            return li;
        }
        else {
            picPaths = picPaths.replaceAll(",", "");
            String[] p = picPaths.split(" ");
            li.addAll(Arrays.asList(p));
            return li;
        }
    }
    
    public String convert(String mins) {
        int min = Integer.parseInt(mins);
        int hours = min / 60;
        int minutes = min % 60;
        String c = "" + hours + " hours " + minutes + " minutes";
        return c;
    }
}
