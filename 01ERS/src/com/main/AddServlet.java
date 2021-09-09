package com.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1 ;
    private TicketDao userDao;

    public void init() {
        userDao = new TicketDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        	        dispatcher.forward(request, response);
        	    }
}
    
    
    

