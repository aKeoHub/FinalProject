<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME nVentory</title>
    </head>
    <body>
        <h1>Hello ${email}</h1>          
        <h1>Shopping List</h1>

        <table class="table">
            <thead>
                <tr>
                    <th>Email</th> 
                    <th>Category</th>
                    <th>Name</th>
                    <th>Price</th>   
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>

                        <td>${item.email}</td>
                        <td>${item.category}</td>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>
                            <form action ="user" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="email" value="${item.email}">
                                <button type="submit">delete</button>
                            </form>

                            <form action ="user" method="post">
                                <input type="hidden" name="action" value="activation">
                                <input type="hidden" name="email" value="${item.email}">
                                <button type="submit">REACTIVATE</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <!--        <form action="user" method="post">
                    <input type="hidden" name="action" value="add">
        
                    
                    <label for="item">Item</label>
                    <input type="text" name="item" id="item">
                    
        
                    <button type="submit">Add</button>
                </form>-->


<!--        <form action="user" method="post">
            <input type="hidden" name="action" value="delete">
            <c:forEach items="${items}" var="item">
                <p>
                    <input type="radio" name="item" value="${item}">
                    ${item}
                </p>
            </c:forEach>

            <button type="submit">Delete</button>
        </form>-->




        <p>                    
            <a href="login">Log out</a>
        </p>



        <p>
            <a href="shoppinglist">View your shopping list</a>
        </p>
        <p>
            <a href="account">Edit Account</a>
        </p>
    </body>
</html>
