package org.certificatic.servlet;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.certificatic.model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet(name = "JsonController", urlPatterns = { "/JsonController", "/json-controller" })
public class JsonController extends HttpServlet{

    private static final long serialVersionUID = 245875312L;
    private String fileName = "/WEB-INF/person.json";    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        // use of try/catch with resources
        try (PrintWriter out = response.getWriter();
            InputStreamReader isr = new InputStreamReader(getServletContext().getResourceAsStream(fileName))) {
            // parse and manipulate the InputStreamReader read resul of person.json
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(isr);
            for(Object o: jsonArray){
                JSONObject jsonPerson = (JSONObject)o;
                long id = (Long)jsonPerson.get("id");
                String name = (String) jsonPerson.get("name");
                long age = (Long)jsonPerson.get("age");
                String city = (String) jsonPerson.get("city");
                String gender = (String) jsonPerson.get("gender");
                String job = (String) jsonPerson.get("job");
                JSONArray books = (JSONArray) jsonPerson.get("books");
                ArrayList<String> books_ = new ArrayList<String>();
                for (Object book : books) {
                    books_.add((String)book);
                }
                // create and return a Person foreach jsonObject found
                // TODO: return in jsp
                out.println(new Person(id, name, (int)age, city, gender, job, books));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        //TODO: read the value from the request
        ArrayList<String> books = new ArrayList<>();
        books.add("Mastering Java 9");
        books.add("Java 9 Modularity: Patterns and Practices for Developing Maintainable Applications");
        Person person = new Person(
            3,
            "Daniela",
            23,
            "CDMX",
            "female",
            "Master Programmer",
            books
        );
        // create JSONObject with the incomming values
        JSONObject jsonPerson = new JSONObject();
        JSONArray books_ = new JSONArray();
        books_.addAll(books);
        jsonPerson.put("id", person.getId());
        jsonPerson.put("name", person.getName());
        jsonPerson.put("age", person.getAge());
        jsonPerson.put("city", person.getCity());
        jsonPerson.put("gender", person.getGender());
        jsonPerson.put("job", person.getJob());
        jsonPerson.put("books", person.getBooks());
        // retreive the current content of the file
        try (InputStreamReader isr = new InputStreamReader(this.getServletContext().getResourceAsStream(fileName));
            FileWriter file = new FileWriter(this.getServletContext().getRealPath("/") + fileName)){
            JSONParser jsonParser = new JSONParser();
            JSONArray arrayArray = (JSONArray) jsonParser.parse(isr);
            arrayArray.add(jsonPerson);
            // write to the file
            file.write(arrayArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}