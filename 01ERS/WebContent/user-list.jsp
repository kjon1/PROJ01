<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Portal</title>
</head>
<style>

        ul{
            list-style: none;
            background-color: rgba(46, 41, 38, 0.692);
            width: 900px;
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
            width: 835px;
            height: 500px;
            border: 2px solid rgb(238, 238, 238);
            text-align: "center"
            margin-left: 33px;
            color: white;
            background-color: rgb(182, 202, 221);
            font-size: 29px;
            
            
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
        .h2{
        font-size: 22px;
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
                    opacity: 0.5;
        
        
        
        }
h1{
color:white;
text-align:center;
margin:center;


}


btn{
width: 200px;
padding: 14px 30px;
text-decoration:none;
            text-transform: capitalize;
            font-family: 'Oswald', sans-serif;
            border: 1px;
            border-radius: 14px;
            font-size: 16px;
            align-content: center;
            background-color: gold;
            margin-right: 18px;
            }


</style>
<head>
 <title>User Management Application</title>
</head>
<body>

    <ul>
        <li><a href="welcome.jsp">Home</a></li>
        <li><a href="login.jsp">Employees</a></li>
        <li><a href="add">New Request</a></li>
        <li><a href="list">View My Tickets</a></li>
        

    </ul>
    
</body>
<body>
 <center>
  <h1>Reimbursement Portal</h1>
     
 </center>
 <div><%String username=(String)session.getAttribute("username");
out.print("Hello, "+username+ " .");%></div>
    <div align="center">
    <div> <c:set var="u" value="${username}" scope="session" /> 
    <% session.setAttribute("username", String.valueOf(username));%>
   // <h3></h3>
    </div>
    <div class="wrapper">
        <table border="1" width="800" font-size = "24px">
            <caption><h2>Ticket History</h2></caption>
            <tr >
                <th>RID</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Description</th>
                <th>Timestamp</th>
                <th>Status</th>
                               
            </tr>
            <c:forEach var="ticket" items="${listTicket}">
                <tr>
                    <td><c:out value="${ticket.rid}" /></td>
                    <td><c:out value="${ticket.type}" /></td>
                    <td><c:out value="${ticket.amount}" /></td>
                    <td><c:out value="${ticket.description}" /></td>
                    <td><c:out value="${ticket.timestamp}" /></td>
                    <td><c:out value="${ticket.status}" /></td>
                    
                            
                </tr>
            </c:forEach>
        </table>
    </div> 
    </div>
</body>
</html>