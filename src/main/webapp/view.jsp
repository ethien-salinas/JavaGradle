<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <div class="container">
        <h1>View</h1>
        <div class="card" style="width: 20rem;">
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${param.year}</li>
                <li class="list-group-item">${param.season}</li>
                <li class="list-group-item">${param.title}</li>
            </ul>
        </div>
    </div>
</body>
</html>
