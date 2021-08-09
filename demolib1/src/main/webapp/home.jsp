<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header"><p style="font-size:30px;color:blue;">Library</p></div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li class="active"><a href="mybooks">My Books</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form></li>
      <li><a href="signout"><span class="glyphicon glyphicon-user"></span> Sign out</a></li>
    </ul> 
  </div>
</nav>



<table id="messages" class="table table-striped table-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Book Name</th>
                <th scope="col">count</th>
                <th scope="col">Add</th>
            </tr>

            <c:forEach var="msg" items="${requestScope.messageList}">
                <tr>
                    <td>${msg[0]}</td>
                    <td>${msg[1]}</td>
                    <td>${msg[2]}</td>
                    <td>
                    <form action="./addbook?book=${msg[1]}" method="post">
					<button name="book" type="submit" value="${msg[1]}">ADD</button>
					</form>
                    </td>
                </tr>
            </c:forEach>    
</table> 
<div style="color:red;" >${message}</div>


</body>
</html>