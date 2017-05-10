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
import javax.servlet.http.HttpSession;
import models.Account;

/**
 *
 * @author Shawn
 */
public class RegisterPage extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String homepage = "index";
        String registerPageURL = "JSP/register.jsp";
        Short notLoggedIn = (short) 0;
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");
        if(user == null || user.getLoggedIn() == notLoggedIn) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(registerPageURL);
            dispatcher.forward(request, response);
        }
        else {
           response.sendRedirect(homepage);
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
}
