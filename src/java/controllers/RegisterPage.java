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
import models.TempAccountInfo;
import models.Error;

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
            Error err = (Error) request.getSession().getAttribute("err");
           TempAccountInfo temp = (TempAccountInfo) request.getSession().getAttribute("temp");
           if(err!=null) {
               request.setAttribute("err3", err);
               request.getSession().removeAttribute("err");
           }
           if (temp!=null) {
               request.setAttribute("temp3", temp);
               request.getSession().removeAttribute("temp");
           }
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
