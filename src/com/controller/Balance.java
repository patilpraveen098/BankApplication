package com.controller;

import com.model.Model;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Balance extends HttpServlet {
   public void service(HttpServletRequest req, HttpServletResponse resp) {
      try {
         HttpSession hs = req.getSession();
         String pwd = (String)hs.getAttribute("pass");
         int accno = (Integer)hs.getAttribute("accno");
         String pass = req.getParameter("pass");
         System.out.println("Password matching");
         if (pwd.equals(pass)) {
            Model m = new Model();
            m.setAccno(accno);
            boolean status = m.viewBalance();
            int bal = m.getBalance();
            System.out.println("redirecting to bal success");
            if (status) {
               hs.setAttribute("newbal", bal);
               resp.sendRedirect("/BankApplication/balancesuccess.jsp");
            } else {
               resp.sendRedirect("/BankApplication/balancefail.html");
            }
         } else {
            resp.sendRedirect("/BankApplication/balanceerror.html");
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }
}
