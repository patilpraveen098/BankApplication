package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeNameVal extends HttpServlet {
   protected void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         String nn = req.getParameter("nn");
         String p = req.getParameter("p");
         if (nn.length() != 0 && p.length() != 0) {
            req.getServletContext().getRequestDispatcher("/ChangeName").forward(req, resp);
         } else {
            resp.sendRedirect("/BankApplication/changenameerror.html");
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}