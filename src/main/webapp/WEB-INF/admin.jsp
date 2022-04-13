<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Welcome ${email}</h1>
        <h2>Admin Functionality...</h2>

            <p>
                <a href="category">View Categories</a>
            </p>
        <table class="table">
            <thead>
                <tr>
                    <th>E-mail</th>
                    <th>First Name</th>
                    <th>Last Name</th>   
                    <th>Active</th> 
                    <th>Role</th>
                    <th>Actions</th>  
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.active ? "Y" : "N"}</td>
                        <td>${user.role.roleName}</td>
                        <td>
                            <form action ="admin" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="email" value="${user.email}">
                                <button type="submit">delete</button>
                            </form>

                            <form action ="admin" method="post">
                                <input type="hidden" name="action" value="activation">
                                <input type="hidden" name="email" value="${user.email}">
                                <button type="submit">REACTIVATE</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
                 <h2>Add user</h2>
                <form action="admin" method="post">
                    <input type="hidden" name="action" value="add">

                    <label for="email">E-mail</label>
                    <input type="text" name="email" id="email">
                    <br>
                    <label for="first">First Name</label>
                    <input type="text" name="first" id="first">
                    <br>
                    <label for="last">Last Name</label>
                    <input type="text" name="last" id="last">
                    <br>
                    <label for="password">Password</label>
                    <input type="text" name="password" id="password">
                    <br>
                    <label for="role">Role</label>
                    <select name="role" id="role">
                        <option value="1">System Admin</option>
                        <option value="2">Regular User</option>
                        <option value="3">Company Admin</option>
                    </select>

                    <button type="submit">Add</button>
                </form>

                <h2> Edit user </h2>
                <form action="admin" method="post">
                    <input type="hidden" name="action" value="edit">

                    <label for="email">E-mail</label>
                    <input type="text" name="email" id="email">
                    <br>
                    <label for="first">First Name</label>
                    <input type="text" name="first" id="first">
                    <br>
                    <label for="last">Last Name</label>
                    <input type="text" name="last" id="last">
                    <br>
                    <label for="password">Password</label>
                    <input type="text" name="password" id="password">
                    <br>
                    <label for="role">Role</label>
                    <select name="role" id="role">
                        <option value="1">System Admin</option>
                        <option value="2">Regular User</option>
                        <option value="3">Company Admin</option>
                    </select>

                    <button type="submit">Edit</button>
                </form>
            <p>
                <a href="login">Log out</a>
            </p>
    </body>
</html>
