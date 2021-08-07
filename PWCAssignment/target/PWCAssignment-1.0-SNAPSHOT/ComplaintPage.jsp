
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/6/2021
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>ComplaintPage</title>
    <link rel="stylesheet" href="Style.css">
    <link rel="icon" type="image/jpg" href="https://i.postimg.cc/7LLWK8FC/photo-1499159058454-75067059248a.jpg" />
</head>
<body>

<header class="main">
    <h1> complaints page </h1>
    <nav>
        <a href = "LogOut"> LogOut </a>
    </nav>
</header>
    <form method="post" action="ComplaintPage" >
        <div class="mainComp">
            <div class=" type">
                <label for="complaint">Choose the Complaint type:</label>
                <select name="complaint" id="complaint" class="dropContent">
                    <option value="none" selected disabled hidden>Complaint type</option>
                    <option value="Privacy" >Privacy complaint</option>
                    <option value="Product" >product complaint</option>
                    <option value="Price" >Price complaint</option>
                    <option value="Employees" >Employees complaint</option>
                </select>
            <br><br>
            </div>
            <div class ="type">
                <p> Critical or Not critical issue: </p>
                <input type="checkbox" id="critical" name="critical" value="critical">
                <label for="critical" class="label"> Critical Issue</label><br>
                <input type="checkbox" id="notCritical" name="not Critical" value="not critical">
                <label for="notCritical" class = "label"> Not critical Issue</label>

            </div>
            <div class="type">
                <label for="branch">The branch of the company for which the complaint is filed:</label>
                <br>
                <select name="branch" id="branch" multiple class="select" required>
                    <option value="Amman">Amman</option>
                    <option value="Salt">Salt</option>
                    <option value="Jarash">Jarash</option>
                    <option value="Madaba">Madaba</option>
                </select>
            </div>
            <br>
            <br>
            <br>
            <div class="type">
                <input type="text" placeholder="Additional note about the complaint" name="AdditionalNote" minlength="0" maxlength="1000" value="" class="note" >

            </div>
            <input type="submit" value="Submit" class="submitButton">

            <div>
            <c:if test = "${ not empty sessionScope.temp}">
                <table class="tt">
                    <tr>
                        <th> Complaint Information</th>
                    </tr>
                    <c:forEach items="${sessionScope.list}" var="complaintInformation">
                            <tr>
                                <td>
                                   The status of Complaint number ${ complaintInformation}
                                </td>
                            </tr>
                     </c:forEach>


                </table>
            </c:if>
            </div>
        </form>
    </div>
</body>
</html>
