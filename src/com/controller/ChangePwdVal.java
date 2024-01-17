package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePwdVal extends HttpServlet {
   protected void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         String op = req.getParameter("op");
         String np = req.getParameter("np");
         String cp = req.getParameter("cp");
         if (op.length() != 0 && np.length() != 0 && cp.length() != 0) {
            if (np.equals(cp)) {
               req.getServletContext().getRequestDispatcher("/ChangePwd").forward(req, resp);
            } else {
               resp.sendRedirect("/BankApplication/changepwderror.html");
            }
         } else {
            resp.sendRedirect("/BankApplication/changepwderror.html");
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }
}