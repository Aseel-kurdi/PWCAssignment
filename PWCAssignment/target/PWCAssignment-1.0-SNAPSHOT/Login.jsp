<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/5/2021
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="Style.css">
    <link rel="icon" type="image/jpg" href="https://i.postimg.cc/7LLWK8FC/photo-1499159058454-75067059248a.jpg" />
</head>
<body>
<div class="container">
    <form action="LoginPage" method="post">
        <div class="login-box">
            <h1>Login</h1>
            <div class="textBox">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Client full name" name="ClientFullName"  value=""  required>
                <br>
                <i class="fas fa-envelope-open"></i>
                <input type="email" placeholder="Email" name="Email" value="">
                <br>
                <i class="fas fa-phone-alt"></i>
                <input type="text" placeholder="Phone number" name="phoneNumber" value="" pattern="^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$"
                       required >
                <br>
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Password" id="myinput"name="pass" value="" required>
            </div>
            <input class = "button" type="submit" value="LogIn"  >
            <div class="link">
                <a href="SignUpPage">Sign Up</a>
            </div>



        </div>



    </form>
</div>
<c:if test = "${ not empty requestScope.invalidClientData}">
    <script>
        confirm("${requestScope.invalidClientData}");
    </script>
</c:if>
    <script>
        function confirmPassword(){
        var x =document.getElementById("myinput");
        var y =document.getElementById("hide1");
        var z =document.getElementById("hide2");
        if(x.type==='password'){
            x.type="text";
            y.style.display="block";
            z.style.display="none";
        }
        else{
        x.type="password";
            y.style.display="none";
            z.style.display="block";
        }
        }
    </script>
</body>
</html>
