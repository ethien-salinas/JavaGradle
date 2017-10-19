package org.certificatic.servlet;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.certificatic.model.Person;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "JsonController", urlPatterns = { "/JsonController", "/json-controller" })
public class JsonController extends HttpServlet{

    private static final long serialVersionUID = 245875312L;
    private String fileName = "/WEB-INF/person.json";

    private JSONArray readJsonFromFile(){
        JSONArray jsonArray = null;
        String result = "";
        try (InputStreamReader isr = new InputStreamReader(getServletContext().getResourceAsStream(fileName))) {
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
            jsonArray = new JSONArray(result);
            isr.close();
        } catch (IOException e) {
			e.printStackTrace();
		}
        return jsonArray;
     }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try (PrintWriter out = response.getWriter()){
            JSONArray jsonArray = this.readJsonFromFile();
            RequestDispatcher rd = request.getRequestDispatcher("persons.jsp");
            ArrayList<Person> persons = new ArrayList<>();
            for(Object o: jsonArray){
                JSONObject jsonPerson = (JSONObject)o;
                int id = (Integer)jsonPerson.get("id");
                String name = (String) jsonPerson.get("name");
                int age = (Integer)jsonPerson.get("age");
                String city = (String) jsonPerson.get("city");
                String gender = (String) jsonPerson.get("gender");
                String job = (String) jsonPerson.get("job");
                JSONArray books = (JSONArray) jsonPerson.get("books");
                ArrayList<String> books_ = new ArrayList<String>();
                for (Object book : books) {
                    books_.add((String)book);
                }
                persons.add(new Person(id, name, age, city, gender, job, books_));
            }
            request.setAttribute("persons", persons);
            rd.forward(request, response);
        } catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        //TODO: read the value from the request
        Person person = new Person(
            3,
            "Daniela",
            23,
            "CDMX",
            "female",
            "Master Programmer",
            new ArrayList<String>(
                Arrays.asList(
                    "Mastering Java 9",
                    "Java 9 Modularity"
                )
            )
        );
        // create JSONObject with the incomming values
        JSONObject jsonPerson = new JSONObject();
        JSONArray books_ = new JSONArray();
        books_.put(person);
        jsonPerson.put("id", person.getId());
        jsonPerson.put("name", person.getName());
        jsonPerson.put("age", person.getAge());
        jsonPerson.put("city", person.getCity());
        jsonPerson.put("gender", person.getGender());
        jsonPerson.put("job", person.getJob());
        jsonPerson.put("books", person.getBooks());
        JSONArray jsonArray = this.readJsonFromFile();
        try (FileWriter file = new FileWriter(this.getServletContext().getRealPath("/") + fileName)){
            jsonArray.put(jsonPerson);
            file.write(jsonArray.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
			e.printStackTrace();
		}
    }

}