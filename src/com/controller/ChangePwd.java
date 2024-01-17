package com.controller;

import com.model.Model;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePwd extends HttpServlet {
   protected void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         String op = req.getParameter("op");
         String np = req.getParameter("np");
         HttpSession hs = req.getSession();
         int accno = (Integer)hs.getAttribute("accno");
         Model m = new Model();
         m.setAccno(accno);
         m.setPass(op);
         boolean status = m.changePwd(np);
         if (status) {
            resp.sendRedirect("/BankApplication/changepwdsuccess.html");
         } else {
            resp.sendRedirect("/BankApplication/changepwdfail.html");
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }
}