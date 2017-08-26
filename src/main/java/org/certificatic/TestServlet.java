package org.certificatic;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet NewServlet at " + request.getRemotePort()+ "</h1>");
            out.println("<h1>Servlet NewServlet at " + request.getMethod()+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet NewServlet at " + request.getRemotePort()+ "</h1>");
            out.println("<h1>Servlet NewServlet at " + request.getMethod()+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
