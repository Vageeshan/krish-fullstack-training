<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo Management App</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #02021c">
        <div>
            <a href="https://www.vageeshan.net" class="navbar-brand"> Todo Management App </a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Todos</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${todo != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${todo == null}">
                <form action="insert" method="post">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${todo != null}">
                                Edit Todo
                            </c:if>
                            <c:if test="${todo == null}">
                                Add New Todo
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${todo != null}">
                        <input type="hidden" name="id" value="<c:out value='${todo.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Task Name</label> <input type="text"
                                                        value="<c:out value='${todo.task}' />" class="form-control"
                                                        name="task" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Author</label> <input type="text"
                                                     value="<c:out value='${todo.author}' />" class="form-control"
                                                     name="author">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task Description</label> <input type="text"
                                                               value="<c:out value='${todo.description}' />"
                                                               class="form-control"
                                                               name="description">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
