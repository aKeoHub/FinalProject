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

                    <button type="submit">Register</button>
                </form>
        <a href="login">Login</a>
    </body>
</html>
