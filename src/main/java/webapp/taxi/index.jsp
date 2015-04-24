<%--
  Created by IntelliJ IDEA.
  User: Galabut
  Date: 14.04.2015
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>User Login</title>
</head>
<body>
<form action="/authServlet" method="get">
    <table cellspacing="5" cellpadding="5">
        <tr>
            <td colspan="2" align="center"><h1>User Login</h1>
            </td>
        </tr>
        <tr>
            <td><label>Login:</label></td>
            <td><input type="text" name="login" placeholder="${login}" class="colorText"/></td>

        </tr>
        <tr>
            <td><label>Password:</label></td>
            <td><input type="text" name="password" placeholder="${password}"/></td>
        </tr>
        <tr>
            <td id="cell" align="right" colspan="2"><input type="submit" value="Login"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><p class="userInputError">${error}</p>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
