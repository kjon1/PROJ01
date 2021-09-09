<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>

        ul{
            list-style: none;
            background-color: rgba(46, 41, 38, 0.692);
            width: 990px;
            padding: 20px;
            margin: 0 auto;
            margin-top: 20px;
            border-radius: 10px;
        }

        li{
            display: inline-block
        }

        a{
            text-decoration: none;
            color: #fff;
            padding: 40px;
            font-size: 24px;
            font-family: 'Oswald', sans-serif;
        }

        a:hover{
            background-color: rgb(156, 173, 204);
            font-size: 22px;
            transition: 0.8s;
        }
        .center {
  margin-left: auto;
  margin-right: auto;
}
        
        body{
        background-image: url(https://40obml2t8u691fd442y9pg71-wpengine.netdna-ssl.com/wp-content/uploads/login-page-bg.jpg);
        background-size: cover;
        
            background-color: rgba(93, 115, 121, 0.692);
        }
        .wrapper{
            width: 555px;
            height: 290px;
            border: 2px solid rgb(238, 238, 238);
            text-align: "center"
            color: white;
            
            margin-left: 240px; 
            
        }

        .mydiv{
            padding: 120px;
            /* width: 160px;
            height: 160px; */
            box-sizing: border-box;
        }
        .myh1{
            font-size: 24px;
            font-weight: bold;
            //font-style: italic;
            text-align: center;
            color: rgba(19, 11, 5, 0.692); 
        }

        .btn{
            background-color: rgb(27, 61, 63);
            color: #fff;
            padding: 5px 60px;
            text-transform: capitalize;
            font-family: 'Oswald', sans-serif;
            border: 0px;
            border-radius: 2px;
            font-size: 16px;
        }
        p1{
                    opacity: 0.9;
                    font-size: 24px;
        
        
        
        }
h1{
color:white;
text-align:center;
margin-top: 25px;
margin-bottom: 25px;
align-content: center;


}


</style>
<title>Manager Page</title>
</head>

<body>

<body>

    <ul>
        <li><a href="welcome.jsp">Login Home</a></li>
        <li><a href="ViewE">View requests</a></li>
       <li><a href="pList">View pending </a></li>
       <li><a href="pList">Update Ticket </a></li>
        
   </ul>
    <h1>Finance Manager Portal</h1>
 <div class ="wrapper">

      
  
  <p1><%String username=(String)session.getAttribute("username");
out.print("Hello, "+username+ " .");%>

</p1>
 </div>
</body>
</html>