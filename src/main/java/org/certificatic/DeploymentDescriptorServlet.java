package org.certificatic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeploymentDescriptorServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest resquest, HttpServletResponse response)
    throws IOException{
        try(PrintWriter out = response.getWriter()){
            out.print("Esta vivo!!!");
        }
    }
    
}