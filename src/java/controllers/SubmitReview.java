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
import models.Account;
import models.PlayingMovie;

/**
 *
 * @author Shawn
 */
public class SubmitReview extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String review = request.getParameter("review").trim();
        String rating = request.getParameter("rating").trim();
        Account acc = (Account) request.getSession().getAttribute("user");
        MovieManager mm = (MovieManager) request.getServletContext().getAttribute("movieManager");
        PlayingMovie pm = (PlayingMovie) request.getSession().getAttribute("movie");
        if(review == null || review.equals("")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(pm.getTitle());
            //   ../movie/reviews/" + pm.getTitle()
            dispatcher.forward(request, response);
            return;
        }
        if(acc == null || acc.getLoggedIn() == (short) 0) {
            //go back to the review servlet
            RequestDispatcher dispatcher = request.getRequestDispatcher(pm.getTitle());
            //   ../movie/reviews/" + pm.getTitle()
            dispatcher.forward(request, response);
            //response.sendRedirect("reviews/" + pm.getTitle());
            return;
        }
        else {
            PlayingMovie pm2 = mm.findMovie(pm.getTitle());
            String rev = pm2.getReviews();
            if(rev!=null)
                rev = rev.concat(review + " - " + rating + "/10" + "\t");
            else
                rev = review + " - " + rating + "/10" + "\t";
            pm2.setReviews(rev);
            mm.update(pm2);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(pm.getTitle());
        //   ../movie/reviews/" + pm.getTitle()
        dispatcher.forward(request, response);
        //response.sendRedirect("reviews/" + pm.getTitle());
        return;
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
