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
    <title>SignUP</title>
    <link rel="stylesheet" href="Style.css">
    <link rel="icon" type="image/jpg" href="https://i.postimg.cc/7LLWK8FC/photo-1499159058454-75067059248a.jpg" />
</head>
<body>
<div class="container">
    <form action="SignUpPage" method="post">
        <div class="login-box">
            <h1>Sign Up</h1>
            <div class="textBox">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="First name" name="FirstName" minlength="3" maxlength="15" value="" pattern="[a-zA-Z]+" required>
                <br>
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Last name" name="LastName" minlength="3" maxlength="15" value="" pattern="[a-zA-Z]+" required>
                <br>
                <i class="fas fa-envelope-open"></i>
                <input type="email" placeholder="Email" name="Email" value="">
                <br>
                <i class="fas fa-phone-alt"></i>
                <input type="text" placeholder="Phone number" name="phoneNumber" value="" pattern="^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$"
                       required >
                <br>
                <i class="fas fa-lock"></i>
                <input type="Password" placeholder="Password" name="pass" value="" id ="pass1" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
                       oninvalid="InvalidMsg(this);" required>
                <br>

                    <i class="fas fa-lock"></i>
                    <input type="Password" placeholder="Confirm password"name=""value="" id ="pass2"  onchange="return check()" required>
                    <p id="pass" style="display: none">Passwords are not the same</p>
                <br>


                <input class = "button" type="submit" value="Submit">
                <br>
                <div class="link">
                    <a href="LoginPage">Already Have One?</a>
                </div>
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
    function check() {
        // body...
        var p1 = document.getElementById("pass1");
        var p2 = document.getElementById("pass2");

        if (p1.value != p2.value){
            var x= document.getElementById("pass");
            x.style.display = "block";
            return false ;

        }
    }

    function InvalidMsg(textBox) {

        if(textBox.validity.patternMismatch){
            textBox.setCustomValidity('Password should contains lower case letter, upper case letter and number');
        }
        else {
            textBox.setCustomValidity('');
        }
        return true;
    }
</script>


</body>
</html>
