package com.itranswarp.learnjava.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SuccessSignIn")
public class SuccessSignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("X-Powered","JavaEE Servlet");
        PrintWriter pw = resp.getWriter();
        String username = (String)req.getSession().getAttribute("username");
        if(username == null){
            //未登录，显示登录链接
            pw.write("<h1>未登录，请登录</h1>");
            pw.write("<p><a href=\"siginin\">Sign In</a></p>");
        }else{
            pw.write("<h1>"+"Welcome,"+username+"</h1>");
            pw.write("<p><a href=\"signout\">Sign Out</a></p>");

        }
        pw.flush();
    }
}
