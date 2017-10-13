package org.certificatic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.certificatic.models.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet(name = "JsonController", urlPatterns = { "/JsonController", "/json-controller" })
public class JsonController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest resquest, HttpServletResponse response) throws IOException {

        JSONParser parser = new JSONParser();

        try (PrintWriter out = response.getWriter()) {
            String filename = "/WEB-INF/person.json";
            InputStreamReader isr = new InputStreamReader(getServletContext().getResourceAsStream(filename));
            JSONArray arrayElement = (JSONArray) parser.parse(isr);
            for (Object o : arrayElement) {
                JSONObject jsonPerson = (JSONObject) o;
                String name = (String) jsonPerson.get("name");
                long age = (Long) jsonPerson.get("age");
                String city = (String) jsonPerson.get("city");
                String job = (String) jsonPerson.get("job");
                JSONArray books = (JSONArray) jsonPerson.get("books");
                ArrayList<String> books_ = new ArrayList<>();
                for (Object book : books) {
                    books_.add((String)book);
                }
                out.println(new Person(name, (int)age, city, job, books_).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}