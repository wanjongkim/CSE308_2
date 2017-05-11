/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Account;
import managers.AccountManager;
import models.Error;
import models.TempAccountInfo;

/**
 *
 * @author Shawn
 */
public class Login extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String homepage = "index";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountManager as = (AccountManager) request.getServletContext().getAttribute("accountManager");
        boolean logInSuccessful = as.validateAccountInformation(username, password);
        if(logInSuccessful) {
            HttpSession s = request.getSession();
            Account user = as.getUser(username);
            user.setLoggedIn((short) 1);
            s.setAttribute("user", user);
            response.sendRedirect(homepage);
            return;
        }
        else {
            //display error'
            Error err = new Error("Login failed");
            TempAccountInfo temp = new TempAccountInfo();
            temp.setUsername(username);
            request.getSession().setAttribute("err2", err);
            request.getSession().setAttribute("temp", temp);
            response.sendRedirect("signin");
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
