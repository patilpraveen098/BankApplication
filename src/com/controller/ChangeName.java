package com.controller;

import com.model.Model;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeName extends HttpServlet {
   protected void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         String nn = req.getParameter("nn");
         String p = req.getParameter("p");
         HttpSession hs = req.getSession();
         int accno = (Integer)hs.getAttribute("accno");
         Model m = new Model();
         m.setAccno(accno);
         m.setName(nn);
         m.setPass(p);
         boolean status = m.changeName();
         if (status) {
            resp.sendRedirect("/BankApplication/changenamesuccess.html");
         } else {
            resp.sendRedirect("/BankApplication/changenamefail.html");
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }
}