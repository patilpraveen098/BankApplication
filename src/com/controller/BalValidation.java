package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BalValidation extends HttpServlet {
   public void service(HttpServletRequest req, HttpServletResponse resp) {
      System.out.println("Inside service method");

      try {
         String pass = req.getParameter("pass");
         System.out.println("Inside balance validation");
         if (pass.length() == 0) {
            resp.sendRedirect("/BankApplication/balanceerror.html");
         } else {
            req.getServletContext().getRequestDispatcher("/Balance").forward(req, resp);
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }
}