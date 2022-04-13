<%-- 
    Document   : edit
    Created on : 8-Apr-2022, 10:58:34 PM
    Author     : Kingston
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Account information</title>
    </head>
    <body>
        <h1>Edit your information</h1>
    <c:forEach var="user" items="${users}">
        <form action="account" method="post">
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

            <button type="submit">Save</button>
        </form>
        
        <form action="account" method="post">
            <input type="hidden" name="action" value="deactivate" />
            <input type="submit" value="DEACTIVATE">
            <input type="hidden" name="email" value="${user.email}">
        </form>
        
    </c:forEach>
    <a href="login">Logout</a>
</body>
</html>
