# JavaWeb with Gradle

This project shows how to use JavaWeb technology running the project with the Gradle task manager

To run the project
```sh
$ ./gradlew appRun
```

To clean the output folders
```sh
$ ./gradlew clean
```
## Servlets

### TestServlet
Servler to show some basic features like:
* response generating the html directly in the servlet
* response with a jsp through forwarding characteristic
* use of cookies
* use of session attributes

### DeploymentDescriptorServlet
Servlet declared through deployment descriptor file

### FullControllerExample
Servlet that shows a complete mvn example

### JsonController
Servlet to control a json file manipulation making right use of http verbs