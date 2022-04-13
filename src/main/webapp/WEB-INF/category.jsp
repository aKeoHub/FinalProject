<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories</title>
    </head>
    <body>
                <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Category Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>${category.id}</td>
                        <td>${category.name}</td>

                        <td>
                            <form action ="category" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="categoryId" value="${category.id}">
                                <button type="submit">delete</button>
                            </form>


                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            
                             <h2>Add Category</h2>
                <form action="category" method="post">
                    <input type="hidden" name="action" value="add">

                    <label for="id">ID</label>
                    <input type="number" name="id" id="id">
                    <br>
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name">
                    <br>


                    <button type="submit">Add</button>
                </form>

                <h2> Edit Category </h2>
                <form action="category" method="post">
                    <input type="hidden" name="action" value="edit">

                        <label for="id">ID</label>
                    <input type="number" name="id" id="id">
                    <br>
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name">
                    <br>



                    <button type="submit">Edit</button>
                </form>
    </body>
</html>
