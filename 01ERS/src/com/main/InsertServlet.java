package com.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1 ;
    private TicketDao ticketDao;

    public void init() {
        ticketDao = new TicketDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        	        
        	        String user = request.getParameter("user");
        	        String type = request.getParameter("type");
        	        String amount = request.getParameter("amount");
        	        String description = request.getParameter("description");
        	        
        	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        	        String timestamp  = dateFormat.format(new Date());
        	        String status = "Pending";
        	        
        	        
        	        //String timestamp = request.getParameter("description");



        	        Ticket newTicket = new Ticket(user,type,amount,description,timestamp, status);
        	        
        	        
        	        ticketDao.saveTicket(newTicket);
        	        response.sendRedirect("list");
        	    }
        	    }

    
    
    

