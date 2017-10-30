<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css">
    <title>Persons</title>
</head>
<body>
    <section class="section">
        <h1 class="title">Persons</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>City</th>
                    <th>Gender</th>
                    <th>Job</th>
                    <th>Books</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <th scope="row">${person.id}</th>
                        <td>${person.name}</td>
                        <td>${person.age}</td>
                        <td>${person.city}</td>
                        <td>${person.gender}</td>
                        <td>${person.job}</td>
                        <td>${person.books}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
    <section class="section">
        <h2 class="title is-4 is-spaced">Add new person</h2>
        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Name</label>
            </div>
            <div class="field-body">
                <div class="field">
                <p class="control is-expanded has-icons-left">
                    <input class="input" type="text" placeholder="Name">
                    <span class="icon is-small is-left">
                    <i class="fa fa-user"></i>
                    </span>
                </p>
                </div>
                <div class="field">
                    <p class="control is-expanded has-icons-left">
                        <input class="input" type="text" placeholder="Age">
                        <span class="icon is-small is-left">
                        <i class="fa fa-user"></i>
                        </span>
                    </p>
                </div>
            </div>
        </div>
        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label">City</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <p class="control is-expanded has-icons-left">
                        <input class="input" type="text" placeholder="City">
                        <span class="icon is-small is-left">
                        <i class="fa fa-user"></i>
                        </span>
                    </p>
                </div>
            </div>
        </div>
        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label">Gender</label>
            </div>
            <div class="field-body">
                <div class="field is-narrow">
                <div class="control">
                    <label class="radio">
                    <input type="radio" name="member">
                    Male
                    </label>
                    <label class="radio">
                    <input type="radio" name="member">
                    Female
                    </label>
                </div>
                </div>
            </div>
        </div>
        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label">Job</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <p class="control is-expanded has-icons-left">
                        <input class="input" type="text" placeholder="Job">
                        <span class="icon is-small is-left">
                        <i class="fa fa-user"></i>
                        </span>
                    </p>
                </div>
            </div>
        </div>
        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Books</label>
            </div>
            <div class="field-body">
                <div class="field">
                <div class="control">
                    <textarea class="textarea" placeholder="One book per line"></textarea>
                </div>
                </div>
            </div>
        </div>
        <div class="field is-horizontal">
            <div class="field-label">
                <!-- Left empty for spacing -->
            </div>
            <div class="field-body">
                <div class="field">
                <div class="control">
                    <button class="button is-primary">
                    Add person
                    </button>
                </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
