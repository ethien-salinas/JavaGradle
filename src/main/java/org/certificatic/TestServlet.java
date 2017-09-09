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
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet TestServlet at " + request.getRemotePort()+ "</h1>");
            out.println("<h1>Servlet TestServlet at " + request.getMethod()+ "</h1>");
            out.println("<h1>Servlet TestServlet at " + request.getHeader("User-Agent")+ "</h1>");
            out.println("<h1>Servlet TestServlet at " + request.getSession().getAttribute("sessionAttribute")+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        // use of session object
        request.getSession().setAttribute("sessionAttribute", "Ethien sessionAttribute");
        System.out.println(request.getSession().getAttribute("sessionAttribute"));
        // use of cookie
        Cookie cookie = new Cookie("javax.servlet.http.Cookie", "value inside javax.servlet.http.Cookie");
        response.addCookie(cookie);
        System.out.println(request.getSession().getId());
        rd.forward(request, response);
    }
}
