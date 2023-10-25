<%--
  Created by IntelliJ IDEA.
  User: emmanuelmacaulay
  Date: 24/10/2023
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Users Dashboard</title>
</head>
<body>
<h1>
  <%= "USERS LIST" %>
</h1>
<br/>
<table border='1' width='100%'>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Password</th>
    <th>Email</th>
    <th>Country</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  </thead>
  <tbody>
  <%-- For each user in users list display each row and corresponding items. --%>
  <c:forEach var="user" items="${users}">
    <tr>
      <td><c:out value="${user.id}" /></td>
      <td>${user.name}</td>
      <td>${user.password}</td>
      <td>${user.email}</td>
      <td>${user.country}</td>
      <td><a href="EditServlet?id=${user.id}">Edit</a></td>
      <td><a href="DeleteServlet?id=${user.id}">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<br/>
<td><a href="CreateServlet">Add New User</a></td>

</body>
</html>
