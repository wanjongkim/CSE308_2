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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.MovieManager;
import models.Movie;
import models.PicVideo;
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
            //put pictures and videos into something
            String pics = pm.getPicture();
            String vids = pm.getVideo();
            ArrayList converted = convertPicString(pics);
            ArrayList converted1 = convertVidString(vids);
            PicVideo pv = new PicVideo(converted, converted1);
            request.setAttribute("pv", pv);
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
    
    public ArrayList convertVidString(String vidPaths) {
        ArrayList li = new ArrayList();
        if(vidPaths.equalsIgnoreCase("none")) {
            return li;
        }
        else {
            vidPaths = vidPaths.replaceAll(",", "");
            String[] p = vidPaths.split(" ");
            li.addAll(Arrays.asList(p));
            return li;
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
