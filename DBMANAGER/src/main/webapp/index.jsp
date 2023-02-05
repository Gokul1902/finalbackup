<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <title>Login</title>
</head>
<body>
<div class="contain">
            <div class="header-bar">
                <h1 class="logo">DB</h1>
                <ul class="slider-menu">
                    <li>Profile</li>
                    <li>About</li>
                </ul>
            </div>
        </div>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form action="Signpage"  method="post">
                <h1>Create Account</h1>
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>or use your email for registration</span>
              <input id="signname" type="text" name="signname" placeholder="name" required autocomplete="off">
        <input id="signpass" type="password" name="signpass" placeholder="password" required autocomplete="off">
        <input id="signmail" type="email" name="signmail" placeholder="Email" required autocomplete="off">
                <button name="type" value="sign up">sign up</button>
                 <div id="signwrong">
        <%
        HttpSession mess = request.getSession();
        String signMessage = (String)mess.getAttribute("signmessage");
        if(signMessage!=null){
        	out.println(signMessage);
        }
        %></div>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form action="Signpage" method="post">
                <h1>Sign in</h1>
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>or use your account</span>
               <input id="logname" type="text" name="logname" placeholder="name" required autocomplete="off">
        		<input id="logpass" type="password" name="logpass" placeholder="password" required autocomplete="off">
        		<button name="type" value="login">login</button>
        		 <div id="logwrong">
        <%
        
        String logmessage = (String)mess.getAttribute("logmessage");
        if(logmessage!=null){
        	out.println(logmessage);
        }
        %>
        </div>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
</body>
  <script>
  const signUpButton = document.getElementById('signUp');
  const signInButton = document.getElementById('signIn');
  const container = document.getElementById('container');

  signUpButton.addEventListener('click', () => {
  	container.classList.add("right-panel-active");
  });

  signInButton.addEventListener('click', () => {
  	container.classList.remove("right-panel-active");
  });
  </script>
</html>