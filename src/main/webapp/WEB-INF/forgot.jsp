

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <form action="forgot" method="post">
            Email Address: <input type="text" name="email"><br>
            <input type="submit" value="Submit">
        </form>
        <p>${alert}</p>

        <br>
        <br>
        <br>
        <br>
        <form action="login">
            <input type="submit" value="Back to login" />
        </form>

    </body>
</html>
