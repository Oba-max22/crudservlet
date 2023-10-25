<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <h1>Add New User</h1>
    <form action="CreateServlet" method="post">
        <table>
            <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
            <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
            <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
            <tr><td>Country:</td><td>
                <select name="country" style="width:150px">
                    <option>Nigeria</option>
                    <option>USA</option>
                    <option>UK</option>
                    <option>Canada</option>
                    <option>Other</option>
                </select>
            </td></tr>
            <tr><td colspan="2"><input type="submit" value="Save User"/></td></tr>
        </table>
    </form>
</body>
</html>
