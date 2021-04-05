<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body{
background-color:violet;
}
div{
top:20vh;
background-color:pink;
}
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="opacity:0.69">
  <img style="height:80px;width:80px;" alt="/StudReg/index.jsp" src="data:image/png;base64,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">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/StudReg/index.jsp">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/StudReg/Admin.jsp">Admin-Login</a>
      <a class="nav-item nav-link" href="/StudReg/login.jsp">Student login</a>
      <a class="nav-item nav-link " href="/StudReg/register.jsp">register student</a>
      <a class="nav-item nav-link diasabled" href="#">others</a>
    </div>
  </div>
</nav>

<div align="center" >
<h1>WELCOME ADMIN</h1>
<form action="School">
	<button type="submit">view school students</button>
</form>


<!-- <form action="Admin/find">
Enter id to view<input type="number" name="id">
<button type="submit">Delete student</button>
</form> -->


<form action="logout">
	<button type="submit">logout</button>
</form>
</div>
</body>
</html>