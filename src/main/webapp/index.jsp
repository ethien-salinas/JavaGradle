<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <title>$Title$</title>
  </head>
  <body>
    <div class="container">
      <div class="jumbotron">
        <h1 class="display-3">Web Component Development!</h1>
        <p class="lead">With Servlet and JSP TM Technologies</p>
        <hr class="my-4">
      </div>
      <form action="TestServlet" method="GET">
        <div class="form-group">
          <label for="year">Year</label>
          <input
            type="number"
            class="form-control"
            id="year"
            aria-describedby="yearHelp"
            placeholder="Enter year">
        </div>
        <div class="form-group">
          <label for="season">Season</label>
          <select class="form-control" id="season">
            <option value='Spring'>Spring</option>
            <option value='Summer'>Summer</option>
            <option value='Fall'>Fall</option>
            <option value='Winter'>Winter</option>
          </select>
        </div>
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            aria-describedby="titleHelp"
            placeholder="Enter title">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
  </body>
</html>
