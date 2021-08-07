<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/6/2021
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminPage</title>
    <link rel="stylesheet" href="Style.css">
    <link rel="icon" type="image/jpg" href="https://i.postimg.cc/7LLWK8FC/photo-1499159058454-75067059248a.jpg" />
</head>
<body>
<header class="main">
    <nav>
        <a href = "LogOut"> LogOut </a>
    </nav>
</header>
   <div>
       <table border="1px">
           <tr>
               <th>Complaint number</th>
               <th>Client Name</th>
               <th>Complaint type</th>
               <th>Critical or Not</th>
               <th>Company branch</th>
               <th>Notes from client</th>
               <th>Status</th>

           </tr>
           <c:forEach items="${sessionScope.complaintArrayList}" var="complaintArrayList">
               <tr>
                   <td> ${complaintArrayList.number}</td>
                   <td> ${complaintArrayList.clientName}</td>
                   <td> ${complaintArrayList.type}</td>
                   <td> ${complaintArrayList.criticalOrNot}</td>
                   <td> ${complaintArrayList.branch}</td>
                   <td> ${complaintArrayList.additionalNote}</td>
                   <td>
                       <form action="AdminPage" method="post">
                           <input type="hidden" name="id" value="${complaintArrayList.number}">
                           <select name="status" id="status">
                               <option value="none" selected disabled hidden> Choose Status</option>
                               <option value="resolved" >resolved</option>
                               <option value="pending resolution" >pending resolution</option>
                               <option value="dismissed" >dismissed</option>
                           </select>
                           <br>
                           <input type="submit" value="Submit" class = "statusButton">
                       </form>
                   </td>
               </tr>
           </c:forEach>

       </table>
   </div>

</body>
</html>
