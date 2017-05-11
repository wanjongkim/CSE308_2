/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.AccountManager;
import models.TempAccountInfo;
import models.Error;

/**
 *
 * @author Shawn
 */
public class CreateAccount extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String homepage = "../index";
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccountManager as = (AccountManager) request.getServletContext().getAttribute("accountManager");
        boolean accountExists = as.createNewAccount(username, firstName, lastName, email, password);
        if(accountExists == false) {
            response.sendRedirect(homepage);
            return;
        }
        else {
            //display errors
            Error err = new Error("Username already exists");
            request.getSession().setAttribute("err", err);
            TempAccountInfo in = new TempAccountInfo(username, firstName, lastName, email);
            request.getSession().setAttribute("temp", in);
            response.sendRedirect("../register");
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
