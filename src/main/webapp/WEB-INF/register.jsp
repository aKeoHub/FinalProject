<%-- 
    Document   : register
    Created on : 8-Apr-2022, 9:08:34 PM
    Author     : Kingston
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
                        <h2>Add user</h2>
                <form action="register" method="post">
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
    </body>
</html>
