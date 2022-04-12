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
        <h1>Home nVentory List</h1>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th> 
                    <th>Category</th>
                    <th>Name</th>
                    <th>Price</th>  
                    <th>Owner</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>

                        <td>${item.id}</td>
                        <td>${item.category}</td>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.email}</td>
                        <td>
                            <form action ="user" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="${item.id}">
                                <button type="submit">delete</button>
                            </form>

                            <form action ="user" method="post">
                                <input type="hidden" name="action" value="edit">
                                <input type="hidden" name="email" value="${item.email}">
                                <button type="submit">edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="user" method="post">
            <input type="hidden" name="action" value="add">

            <label for="category">Category</label>
            <select name="category" id="category">
                <option value=1>Kitchen</option>
                <option value="2">Bathroom</option>
                <option value="3">Living Room</option>
                <option value="4">Basement</option>
                <option value="5">Bedroom</option>
                <option value="6">Garage</option>
                <option value="7">Office</option>
                <option value="8">Utility Room</option>
                <option value="9">Storage</option>
                <option value="10">Other</option>
            </select>
            <br>
            <label for="name">Name</label>
            <input type="text" name="name" id="name">
            <br>
            <label for="price">Price</label>
            <input type="number" name="price" id="price">
            <br>

            <button type="submit">Add</button>
        </form>
        
        <br>
           
        
              <form action="user" method="post">
            <input type="hidden" name="action" value="edit">

            <label for="id">ID</label>
            <input type="number" name="id" id="id">
            <br>
            <label for="category">Category</label>
            <select name="category" id="category">
                <option value=1>Kitchen</option>
                <option value="2">Bathroom</option>
                <option value="3">Living Room</option>
                <option value="4">Basement</option>
                <option value="5">Bedroom</option>
                <option value="6">Garage</option>
                <option value="7">Office</option>
                <option value="8">Utility Room</option>
                <option value="9">Storage</option>
                <option value="10">Other</option>
            </select>
            <br>
            <label for="name">Name</label>
            <input type="text" name="name" id="name">
            <br>
            <label for="price">Price</label>
            <input type="number" name="price" id="price">
            <br>

            <button type="submit">Edit</button>
        </form>







        <p>                    
            <a href="login">Log out</a>
        </p>




        <p>
            <a href="account">Edit Account</a>
        </p>
    </body>
</html>
