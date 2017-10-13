package org.certificatic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet(name = "JsonController", urlPatterns = {"/JsonController", "/json-controller"})
public class JsonController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest resquest, HttpServletResponse response)
    throws IOException{

        JSONParser parser = new JSONParser();
        
        try(PrintWriter out = response.getWriter()){
            JSONArray a = (JSONArray) parser.parse(new FileReader("/home/ethien/IdeaProjects/JavaGradle/src/main/java/resources/person.json"));
            for (Object o : a){
              JSONObject person = (JSONObject) o;

              String name = (String) person.get("name");
              System.out.println(name);

              String city = (String) person.get("city");
              System.out.println(city);

              String job = (String) person.get("job");
              System.out.println(job);

              JSONArray cars = (JSONArray) person.get("cars");

              for (Object c : cars){
                out.print(c+"");
              }
            }          
            out.print("Esta vivo!!!");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}