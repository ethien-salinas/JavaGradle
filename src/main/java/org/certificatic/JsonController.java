package org.certificatic;

import java.io.FileNotFoundException;
import java.io.FileWriter;
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
    private String fileName = "/WEB-INF/person.json";

    @Override
    protected void doGet(HttpServletRequest resquest, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter();
            InputStreamReader isr = new InputStreamReader(getServletContext().getResourceAsStream(fileName))) {
            JSONParser parser = new JSONParser();
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

    @Override
    protected void doPost(HttpServletRequest resquest, HttpServletResponse response) {
        // TODO: load this model with incomming data
        // load the model
        Person person = new Person("Lalo", 22, "LA", "hipster", null);
        // create json object
        JSONObject jsonObj = new JSONObject();
        JSONArray list = new JSONArray();
        list.add("harry potter and the philosopher's stone");
        list.add("harry potter and the prisoner of azkaban");
        jsonObj.put("name", person.getName());
        jsonObj.put("city", person.getCity());
        jsonObj.put("age", person.getAge());
        jsonObj.put("books", list);
        try (InputStreamReader isr = new InputStreamReader(getServletContext().getResourceAsStream(fileName));
            FileWriter file = new FileWriter(getServletContext().getRealPath("/") + fileName)){
            // before to write, retreive the actual content of the file
            JSONParser parser = new JSONParser();
            JSONArray arrayElement = (JSONArray) parser.parse(isr);
            // append the new objet to the json
            arrayElement.add(jsonObj);
            // write the result
            file.write(arrayElement.toJSONString());
            file.flush();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}