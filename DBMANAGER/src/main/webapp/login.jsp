<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<title>SignIn</title>
<style>

@import url('https://fonts.googleapis.com/css?family=Parisienne|Quicksand&display=swap');
*{
	padding: 0px;
	margin: 0px;
	/*border: 1px solid black;*/
	box-sizing: border-box;
}


        html,
        body {
            height: 100%;
            margin: 0;
        }
      

        .contain {
        	/*background-color: #7B70CE;*/
        	background-image: linear-gradient(to right top, #6845b5, #6e4cb8, #7352bb, #7959be, #7e5fc1, #7f68c7, #8071cc, #8179d1, #8085d8, #8091de, #829de3, #86a8e7);
            position: absolute;
            top: 0%;
            right:0%;
            left: 0%;
            color: #fff;
            margin-top: -10px;
            /*padding:20px;*/
            padding:25px 20px 30px 20px;
            border-bottom-right-radius:25px;
            border-bottom-left-radius:25px;
            border: 1px solid black;
            
        }

       
        .header-bar {
            position: relative;
            width: 100%;
            min-width: 300px;
            height: 60px;
            border: 10px solid transparent;
            border-top: 10px solid #fffa;
            border-left: 10px solid #fffa;
            box-shadow: 4px 4px 5px rgba(0, 0, 0, 0.25) inset;
        }

        .header-bar::after {
            content: '';
            position: absolute;
            top: -10px;
            right: -10px;
            width: 30%;
            height: 49px;
            border: 10px solid transparent;
            border-bottom: 10px solid #fffa;
            border-right: 10px solid #fffa;
            transition: 0.3s linear all;
        }

        .header-bar>.logo {
            position: fixed;
            top: 4.5%;
            left: 3%;
            transform: translateY(-50%);
            color: #fffc;
            font-family: 'Parisienne', cursive;
            cursor: default;
            user-select: none;
        }

        .slider-menu,.disp {
            position: fixed;
            top: 2.9%;
            right: 3%;
            display: flex;
            list-style-type: none;
            margin: 0;
            padding: 0;
            z-index: 1;
            font-size: 1.3em;

        }

        .slider-menu>li {
            display: inline-flex;
            padding: 14px;
            margin-left: 2px;
            font-family: 'Quicksand', sans-serif;
            color: #fff;
            cursor: pointer;
            transition: 0.3s linear all;
            user-select: none;
        }

#log{
	width: 150px;
	height: 150px;
}
body{
    font-family: 'Poppins', sans-serif;
    overflow: hidden;
}

.wave{
	position: fixed;
	bottom: 0;
	left: 0;
	height: 100%;
	z-index: -1;
}

.container{
    width: 100vw;
    height: 100vh;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-gap :7rem;
    padding: 0 2rem;
}

.img{
	display: flex;
	justify-content: flex-end;
	align-items: center;
}

.login-content{
	display: flex;
	justify-content: flex-start;
	align-items: center;
	text-align: center;
}

.img img{
	width: 500px;
}

form{
	width: 360px;
}

.login-content img{
    height: 100px;
}

.login-content h2{
	margin: 15px 0;
	color: #333;
	text-transform: uppercase;
	font-size: 2.9rem;
}

.login-content .input-div{
	position: relative;
    display: grid;
    grid-template-columns: 7% 93%;
    margin: 25px 0;
    padding: 5px 0;
    border-bottom: 2px solid #d9d9d9;
}

.login-content .input-div.one{
	margin-top: 0;
}

.i{
	color: #d9d9d9;
	display: flex;
	justify-content: center;
	align-items: center;
}

.i i{
	transition: .3s;
}

.input-div > div{
    position: relative;
	height: 45px;
}

.input-div > div > h5{
	position: absolute;
	left: 10px;
	top: 50%;
	transform: translateY(-50%);
	color: #999;
	font-size: 18px;
	transition: .3s;
}

.input-div:before, .input-div:after{
	content: '';
	position: absolute;
	bottom: -2px;
	width: 0%;
	height: 2px;
	background-color: #7B70CE;
	transition: .4s;
}

.input-div:before{
	right: 50%;
}

.input-div:after{
	left: 50%;
}

.input-div.focus:before, .input-div.focus:after{
	width: 50%;
}

.input-div.focus > div > h5{
	top: -5px;
	font-size: 15px;
}

.input-div.focus > .i > i{
	color: #7B70CE;
}

.input-div > div > input{
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	border: none;
	outline: none;
	background: none;
	padding: 0.5rem 0.7rem;
	font-size: 1.2rem;
	color: #555;
	font-family: 'poppins', sans-serif;
}

.input-div.pass{
	margin-bottom: 4px;
}
#profile{
	width: 40px;
	height: 40px;
	margin-left: 10px;
	cursor: pointer;
}
#abt{
	margin-top: -5px;
}

/*a{
	display: block;
	text-align: right;
	text-decoration: none;
	color: #999;
	font-size: 0.9rem;
	transition: .3s;
}

a:hover{
	color: #38d39f;
}
*/
.btn{
	display: block;
	width: 100%;
	height: 50px;
	border-radius: 25px;
	outline: none;
	border: none;
	background-image: linear-gradient(to right, #A38CD4, #7B70CE, #A38CD4);
	background-size: 200%;
	font-size: 1.2rem;
	color: #fff;
	font-family: 'Poppins', sans-serif;
	text-transform: uppercase;
	margin: 1rem 0;
	cursor: pointer;
	transition: 777ms;
}
.btn:hover{
	background-position: right;
	display: block;
	background-image: linear-gradient(to left, #6845B5, #7B70CE, #6845B5);
	transform: scale(104%);
}
#img{
	height: 40px;
	width: 40px;
}

.disp{
	display: none;
	color: white;
	border-radius: 5%;
	box-shadow: 8px 10px 18px black;
	background-image: linear-gradient(to right top, #6845b5, #6e4cb8, #7352bb, #7959be, #7e5fc1, #7f68c7, #8071cc, #8179d1, #8085d8, #8091de, #829de3, #86a8e7);
	text-align:center;
}
.hidden:focus ~ form{
	display: block;
	margin: 100px 0px;
	padding: 20px;
}
#logOut{
	display: block;
	text-align: center;
	margin: 13px auto 0px auto;
	padding: 10px;
	font-size: 13px;
	border-radius: 10%;
}
/*hidden details*/
.disp h3{
	text-align: center;
	margin: 13px;

}
.disp p{
	font-size: 20px;
}
#circle{
	height: 50px;
	width: 50px;
	line-height: 50px;
	background-color: #7B70CE;
	border-radius: 50%;
	text-align: center; 
	margin: auto;
	box-shadow: 3px 3px 13px floralwhite;
}

@media screen and (max-width: 1050px){
	.container{
		grid-gap: 5rem;
	}
}

@media screen and (max-width: 1000px){
	form{
		width: 290px;
	}

	.login-content h2{
        font-size: 2.4rem;
        margin: 8px 0;
	}

	.img img{
		width: 400px;
	}
}

@media screen and (max-width: 900px){
	.container{
		grid-template-columns: 1fr;
	}

	.img{
		display: none;
	}

	.wave{
		display: none;
	}

	.login-content{
		justify-content: center;
	}
}

#level{
	position:absolute;
	top:15%;
	left:2;
	padding:10px;
	border-radius:0px 10px 10px 0px;
	font-size:30px;
	background-image: linear-gradient(to right top, #6845b5, #6e4cb8, #7352bb, #7959be, #7e5fc1, #7f68c7, #8071cc, #8179d1, #8085d8, #8091de, #829de3, #86a8e7);
	color:white;
	
}
#pagename{
	position:absolute;
	top:22%;
	left:2;
	padding:10px;
	border-radius:0px 10px 10px 0px;
	font-size:22px;
	background-image: linear-gradient(to right top, #6845b5, #6e4cb8, #7352bb, #7959be, #7e5fc1, #7f68c7, #8071cc, #8179d1, #8085d8, #8091de, #829de3, #86a8e7);
	color:white;
}

</style>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0"); // for proxies
%>
	<div class="contain">
            <div class="header-bar">
                <h1 class="logo">DB</h1>
                <ul class="slider-menu">
                    <li id="abt">About</li>
	                 <a href="#" class="hidden">
                	<img id="img" src="https://download-accl.zoho.com/webdownload?x-service=CLIQ&event-id=f3791c2279a67f6e5cbc8e1beb41ded82eaff7f8ed6b35ac72ab0d87e84757f47664ec878e1834f701f5739517844b2db05a8fb2ff34955c9e9824527c15cd03&x-cli-msg=%7B%22appaccount_id%22%3A%2264396901%22%7D">
                </a>
                <form action="Signpage" class="disp" id="disp">
                			<div id="circle">L</div>
		                    <h3 id="loginname">Lavanya</h3>
							<p id="loginmail">lavanyasrinivasan1811@gmail.com</p>
							<button id="logOut">LOG OUT</button>
						</form>  
                </ul>
                
            </div>
        </div>
        <div id="level"></div>
        <div id="pagename">SQL Login Page</div>
	<div class="container">
		<div class="img">
			<img src="https://download-accl.zoho.com/webdownload?x-service=CLIQ&event-id=f3791c2279a67f6e5cbc8e1beb41ded88aea6c61368914b592ab5b67109c70b55268a85d13f7e5a397f6e4faf4f1d067b05a8fb2ff34955c9e9824527c15cd03&x-cli-msg=%7B%22appaccount_id%22%3A%2264396901%22%7D">
		</div>
		<div class="login-content">
			<form action="checker" method="post">
				<img id="log" src="https://download-accl.zoho.com/webdownload?x-service=CLIQ&event-id=f3791c2279a67f6e5cbc8e1beb41ded8e8cbf966206df97579b8e5a0a6e7996db412e2df12142aaed25a547a181b21fab05a8fb2ff34955c9e9824527c15cd03&x-cli-msg=%7B%22appaccount_id%22%3A%2264396901%22%7D">
				<h2 class="title">Log In</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Username</h5>
           		   		<input type="text" class="input" name="username" required id="user"  autocomplete="off"/>
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Password</h5>
           		    	<input type="password" class="input" name="password" required id="pass"  autocomplete="off"/>
            	   </div>
            	</div>
            	<!-- <a href="#">Forgot Password?</a> -->
            	<input type="submit" class="btn" value="Login">
            	<%
        			HttpSession error = request.getSession();
        			String errorMessage = (String)error.getAttribute("errorMessage");
       				if(errorMessage!=null){
        			out.println(errorMessage);
        			}
        		%>	
            </form>
        </div>
    </div>
    
</body>

<script>
const inputs = document.querySelectorAll(".input");


function addcl(){
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl(){
	let parent = this.parentNode.parentNode;
	if(this.value == ""){
		parent.classList.remove("focus");
	}
}


inputs.forEach(input => {
	input.addEventListener("focus", addcl);
	input.addEventListener("blur", remcl);
});

function detailShow(){
    const x = new XMLHttpRequest();
    x.onreadystatechange = function(){
        if (x.readyState == 4 && x.status == 200){
        	  var jsonobj =JSON.parse(x.responseText);
        	  document.getElementById("loginname").innerHTML=jsonobj["loginname"];
        	  document.getElementById("loginmail").innerHTML=jsonobj["loginmail"];
        	  document.getElementById("circle").innerHTML=jsonobj["loginsingle"];
        	  document.getElementById("level").innerHTML=jsonobj["level"];
            }

        }
    x.open("get","logdetail");
    x.send();
}
detailShow();


</script>
</html>





