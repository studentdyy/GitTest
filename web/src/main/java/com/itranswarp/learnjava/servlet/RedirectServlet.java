package com.itranswarp.learnjava.servlet;

import org.apache.jasper.tagplugins.jstl.core.Url;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
Redirect重定向转发
重定向是指当浏览器请求一个URL时，服务器返回一个重定向指令，
告诉浏览器地址已经变了，麻烦使用新的URL再重新发送新请求。
*/
@WebServlet(urlPatterns = "/hi")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //构造重定向的路径
        String name = req.getParameter("name");
        String redirectToUrl = "/hello" + (name == null ? "" : "?name=" + name);
        resp.sendRedirect(redirectToUrl);
    }
}
