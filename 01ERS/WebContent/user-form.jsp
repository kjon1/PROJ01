<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>

        ul{
            list-style: none;
            background-color: rgba(46, 41, 38, 0.692);
            width: 900px;
            padding: 20px;
            margin: 0 auto;
            margin-top: 13px;
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
            background-color: rgb(226, 210, 197);
            
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
        font-size: 32px;
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
 <title>ERS Employee Portal</title>
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
  <h1>Employee Reimbursement Portal</h1>
        
 </center>
    <div class="wrapper">
  <c:if test="${ticket != null}">
   <form action="updateTicket" method="post">
        </c:if>
        <c:if test="${ticket == null}">
        <form action="<%=request.getContextPath()%>/insert" method="post">
        
        </c:if>
        <table colspan="5" border="1" cellpadding="10">
            <caption>
            
             <h2>
              <c:if test="${ticket != null}">
               Approve Ticket
              </c:if>
              <c:if test="${ticket == null}">
               Add New Ticket
              </c:if>
             </h2>
            </caption>
          <c:if test="${ticket != null}">
           <input type="hidden" name="rid" value="<c:out value='${ticket.rid}' />" />
          </c:if>            
            <tr>
                <th>Username: </th>
                <td>
                 <input type="text" name="user" size="50"
                   value="<c:out value='${ticket.user}' />"
                  />
                </td>
            </tr>
            
            <tr>
                <th>Reimbursement Type: </th>
                <td>
                <select name="type" >
                <option value=""selected>--select type----</option>
                <option value="LODGING">LODGING</option>
                <option value="TRAVEL">TRAVEL</option>
                <option value="FOOD" >FOOD</option>
                <option value="OTHER">OTHER</option>
                </select>
              
         
                </td>
            </tr>
            <tr>
                <th>Amount: </th>
                <td>
                 <input type="text" name="amount" size="50"
                   value="<c:out value='${ticket.amount}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Description: </th>
                <td>
                 <input type="text" name="description" size="100"
                   value="<c:out value='${ticket.description}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="6" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>