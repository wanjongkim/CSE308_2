/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.AccountManager;
import models.Account;
import models.Error;

/**
 *
 * @author Shawn
 */
public class Update extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //update account information in database.
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String email = request.getParameter("email").trim();
        String firstName = request.getParameter("firstname").trim();
        String lastName = request.getParameter("lastname").trim();
        AccountManager as = (AccountManager) request.getServletContext().getAttribute("accountManager");
        Account user = (Account) request.getSession().getAttribute("user");
        boolean accExists = as.accountExists(username);
        Account us = as.find(user.getAccountID());
        if(accExists) {
            //invalid just go back.
            Error err = new Error("Username exists");
            request.setAttribute("err", err);
            System.out.println("ERrraora");
            RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/myAccount.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if(!password.equalsIgnoreCase("")) {
            us.setPassword(password);
        }
        us.setFirstName(firstName);
        us.setLastName(lastName);
        us.setEmail(email);
        us.setUsername(username);
        request.setAttribute("user", us);
        as.update(us);
        RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/myAccount.jsp");
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
