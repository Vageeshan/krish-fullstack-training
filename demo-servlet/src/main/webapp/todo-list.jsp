<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo Management App</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #02021c">
        <div>
            <a href="www.vageeshan.com" class="navbar-brand"> Todo Management App</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Todos</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Todos</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Todo</a>
        </div>
        <br>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Todo</th>
                <th>Author</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="todo" items="${todolist}">
                <tr>
                    <td><c:out value="${todo.task}"/></td>
                    <td><c:out value="${todo.author}"/></td>
                    <td><c:out value="${todo.description}"/></td>
                    <td>
                        <div class="btn-group">
                            <a href="edit?id=<c:out value='${todo.id}' />" class="btn btn-info"><i
                                    class="fa fa-pencil"></i></a>
                            <a href="#" data-id="<c:out value='${todo.id}' />" class="btn btn-danger delete-btn"><i
                                    class="fa fa-trash"></i></a>
                        </div>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div id="confirmation-modal" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirmation</h5>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete this?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger delete-confirm-btn">Delete</button>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function () {
        $('.delete-btn').on('click', function (event) {
            let id = $(this).attr('data-id');
            console.log(id);
            $('#confirmation-modal').modal('show');
            $('.delete-confirm-btn').on('click', function (event) {
                event.preventDefault();
                $('#confirmation-modal').modal('hide');
                $.ajax({
                    method: "get",
                    url: '/demo/delete',
                    data: {
                        id: id,
                    },
                    success: function (data) {
                        console.log(data.meta);
                        if (data.meta === 200) {
                            location.reload();
                        }
                    }
                });
            });
        });
    });
</script>
</body>
</html>
