package org.certificatic;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "FullControllerExample", urlPatterns = {"/FullControllerExample"})
public class FullControllerExample extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("fullView.jsp");
        ExampleModel model = new ExampleModel();
        String name = request.getParameter("name");
        name = (name == null) ? "Secret": name;
        model.setName(name);
        request.setAttribute("model", model);
        rd.forward(request, response);
    }

}
