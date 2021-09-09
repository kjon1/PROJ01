<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Portal</title>
</head>
 <style>
     body{
         background-image: url(https://mocah.org/uploads/posts/583481-landscape-4k.jpg);
         background-size: cover;
     }
     .wrapper{
         width: 940px;
         height:400px;
         margin-top: 220px;
            border-radius: 15px;
            opacity: 0.92;
            text-align: center;
            background-color: rgb(194, 168, 146);
            align-content: center;
            margin: auto;
            grid-column-start: auto;


     }
     .btn1{
        padding: 8px 50px;
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
         color: snow;
         font-size: 24px;
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
        h1{
        font-size: 35px;
        
        }



 </style>
<head>
 <title>User Management Application</title>
</head>
<body>

    <ul>
        <li><a href="welcome.jsp">Login Home</a></li>
        <li><a href="login.jsp">Employees</a></li>
        <li><a href="pList">View Pending Tickets</a></li>
        <li><a href="add">Update Ticket</a></li>

    </ul>
    
</body>
<body>
 <center>
  <h1>Manager Portal</h1>
     
 </center>
 <div><%String username=(String)session.getAttribute("username");
out.print("Hello, "+username+ " .");%></div>
    <div class="wrapper">
    <div> <c:set var="u" value="${username}" scope="session" /> 
    <% session.setAttribute("username", String.valueOf(username));%>
    <h3></h3>
    </div>
        <table border="1" width="920">
            <caption><h2>All Pending Tickets</h2></caption>
            <tr>
                <th>RID</th>
                <th>Applicant</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Description</th>
                <th>Timestamp</th>
                
                               
            </tr>
            <c:forEach var="ticket" items="${listTicket}">
                <tr>
                    <td><c:out value="${ticket.rid}" /></td>
                    <td><c:out value="${ticket.user}" /></td>
                    
                    <td><c:out value="${ticket.type}" /></td>
                    <td><c:out value="${ticket.amount}" /></td>
                    <td><c:out value="${ticket.description}" /></td>
                    <td><c:out value="${ticket.timestamp}" /></td>
                     
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>