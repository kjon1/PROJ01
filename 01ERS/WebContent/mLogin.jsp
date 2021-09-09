<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Login</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 >
 
 <style>
     body{
         background-image: url(https://mocah.org/uploads/posts/583481-landscape-4k.jpg);
         background-size: cover;
     }
     .wrapper{
         width: 500px;
         margin-top: 280px;
            border-radius: 15px;
            opacity: 0.89;
            text-align: center;
            background-color: rgb(194, 168, 146);
            align-content: center;
            margin: auto;
            grid-column-start: auto;


     }
     .btn1{
        padding: 9px 50px;
            text-transform: capitalize;
            font-family: 'Oswald', sans-serif;
            border: 0px;
            border-radius: 14px;
            font-size: 20px;
            align-content: center;
            background-color: rgb(7, 43, 151);
            color: #fff;
            opacity: 1;
     }
     h1{
         
         font-size: 27px;
         color: white;
         margin-bottom: 33px;
     }
     ul{
            list-style: none;
            background-color: rgba(46, 41, 38, 0.692);
            width: 1000px;
            padding: 20px;
            margin: 0 auto;
            margin-top: 10px;
            border-radius: 10px;
        }

        li{
            display: inline-block
        }

        a{
            text-decoration: none;
            color: #fff;
            padding: 40px;
            font-size: 20px;
            font-family: 'Oswald', sans-serif;
        }

        a:hover{
            background-color: rgb(120, 127, 139);
            font-size: 22px;
            transition: 0.4s;
        }
        section{
            min-height: 24px;
        }
        p1{
        text-align: center;
        margin-left: 50px;
        
        }


 </style>
</head>
<body>

    <ul>
        <li><a href="welcome.jsp">Homepage</a></li>
        <li><a href="login.jsp">  Reimbursement Portal </a></li>

    </ul>
    
</body>

<section>
</section>

<body>
<p1>
<%
String login_msg=(String)request.getAttribute("error");  
if(login_msg!=null)
out.println("<font color=red size=5px>"+login_msg+"</font>");
%>


</p>

 <div class="wrapper" >
  <h1>Manager Login</h1>
  <form action="<%=request.getContextPath()%>/mLogin" method="post">
   <div class="form-group">
    <label for="uname">User Name:</label> <input type="text"
     class="form-control" id="username" placeholder="User Name"
     name="username" required>
   </div>
   <div class="form-group">
    <label for="uname">Password:</label> <input type="password"
     class="form-control" id="password" placeholder="Password"
     name="password" required>
   </div>
   <button type="submit" class="btn1">Login</button>

  </form>
 </div>
</body>
</html>