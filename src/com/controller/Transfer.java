package com.controller;

import com.model.Model;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Transfer extends HttpServlet {
   protected void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         int taccno = Integer.parseInt(req.getParameter("taccno"));
         int amount = Integer.parseInt(req.getParameter("amount"));
         HttpSession hs = req.getSession();
         int accno = (Integer)hs.getAttribute("accno");
         Model m = new Model();
         m.setAccno(accno);
         boolean status1 = m.viewBalance();
         if (status1) {
            int bal = m.getBalance();
            if (bal > amount) {
               boolean status = m.transfer(amount, taccno);
               if (status) {
                  resp.sendRedirect("/BankApplication/transfersuccess.html");
               } else {
                  resp.sendRedirect("/BankApplication/transferfail.html");
               }
            } else {
               resp.sendRedirect("/BankApplication/transferfail.html");
            }
         } else {
            resp.sendRedirect("/BankApplication/transferfail.html");
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }

   }
}