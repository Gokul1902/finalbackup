<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import = "javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #logwrong{
        opacity:0;
    }
    #signwrong{
        opacity:0;
    }
</style>
</head>
<body>
    <form action="Signup">
        <h1>login</h1>
        <input id="logname" type="text" name="logname" required>
        <input id="logpass" type="password" name="logpass" required>
        <button name="type" value="login">login</button>
        <div id="logwrong">
        <% %>
        </div>
    </form>
    <form>
        <h1>signup</h1>
        <input id="signname" type="text" name="signname" required>
        <input id="signpass" type="password" name="signpass" required>
        <input id="signmail" type="email" name="signmail" required>
        <div id="signwrong"></div>
        <button name="type" value="sign up">sign up</button>
        </form>
</body>

</html>

