<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit User</title>
</head>
<body>
<h1>Change User Details</h1>
<form action="EditServlet" method="post">
  <table>
    <tr><td><input type="hidden" name="id" value="${id}" /></td></tr>
    <tr><td>Name:</td><td><input type="text" name="name" value="${name}"/></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password" value="${password}"/></td></tr>
    <tr><td>Email:</td><td><input type="email" name="email" value="${email}"/></td></tr>
    <tr><td>Country:</td><td>
      <select name="country" style="width:150px">
        <option>Nigeria</option>
        <option>USA</option>
        <option>UK</option>
        <option>Canada</option>
        <option>Other</option>
      </select>
    </td></tr>
    <tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
  </table>
</form>
</body>
</html>
