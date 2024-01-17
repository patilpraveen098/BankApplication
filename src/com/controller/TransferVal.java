package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransferVal extends HttpServlet {
   protected void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         String taccno = req.getParameter("taccno");
         String amount = req.getParameter("amount");
         if (taccno.length() != 0 && amount.length() != 0) {
            req.getServletContext().getRequestDispatcher("/Transfer").forward(req, resp);
         } else {
            resp.sendRedirect("/BankApplication/transfererror.html");
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}