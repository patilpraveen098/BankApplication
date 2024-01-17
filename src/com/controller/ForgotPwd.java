package com.controller;

import com.model.Model;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotPwd extends HttpServlet {
   protected void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         int accno = Integer.parseInt(req.getParameter("accno"));
         String name = req.getParameter("name");
         String email = req.getParameter("email");
         String np = req.getParameter("np");
         Model m = new Model();
         m.setAccno(accno);
         m.setName(name);
         m.setEmail(email);
         boolean status = m.forgotPassword(np);
         if (status) {
            resp.sendRedirect("/BankApplication/forgotpwdsuccess.html");
         } else {
            resp.sendRedirect("/BankApplication/forgotpwdfail.html");
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }
}