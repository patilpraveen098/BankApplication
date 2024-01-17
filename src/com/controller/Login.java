package com.controller;

import com.model.Model;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
   public void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         int accno = Integer.parseInt(req.getParameter("accno"));
         String pass = req.getParameter("pass");
         Model m = new Model();
         m.setAccno(accno);
         m.setPass(pass);
         boolean status = m.login();
         if (status) {
            int a = m.getAccno();
            String b = m.getName();
            String c = m.getPass();
            String d = m.getEmail();
            int e = m.getBalance();
            HttpSession hs = req.getSession(true);
            hs.setAttribute("accno", a);
            hs.setAttribute("name", b);
            hs.setAttribute("pass", c);
            hs.setAttribute("email", d);
            hs.setAttribute("balance", e);
            resp.sendRedirect("/BankApplication/welcome.jsp");
         } else {
            resp.sendRedirect("/BankApplication/incorrect.html");
         }
      } catch (Exception var13) {
         var13.printStackTrace();
      }

   }
}