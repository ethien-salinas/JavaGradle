package org.certificatic;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css' integrity='sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M' crossorigin='anonymous'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet [context path] " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet TestServlet [remote port] " + request.getRemotePort()+ "</h1>");
            out.println("<h1>Servlet TestServlet [method] " + request.getMethod()+ "</h1>");
            out.println("<h2>Servlet TestServlet [User-Agent] " + request.getHeader("User-Agent")+ "</h2>");
            out.println("<h3>Servlet TestServlet [parameter:year] " + request.getParameter("year")+ "</h3>");
            out.println("<h3>Servlet TestServlet [parameter:season] " + request.getParameter("season")+ "</h3>");
            out.println("<h3>Servlet TestServlet [parameter:title] " + request.getParameter("title")+ "</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        // use of session object
        System.out.println(request.getSession().getAttribute("ts-session-value"));
        System.out.println(request.getSession().getId());
        // use of cookies
        Cookie cookie = new Cookie("javax.servlet.http.Cookie", "Este valor viaja dentro de una cookie");
        response.addCookie(cookie);
        // forwarding
        rd.forward(request, response);
    }
}
