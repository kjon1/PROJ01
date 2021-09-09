package com.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;


@WebServlet("/")
public class TicketController extends HttpServlet {
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
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    rForm(request, response);
                    break;
                case "/insert":
                    insertTicket(request, response);
                    break;
                case "/cancel":
                    deleteTicket(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTicket(request, response);
                    break;
                    
                case "/pList":
                	pList(request, response);
                default:
                    list(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	HttpSession session = request.getSession();
    	String username=(String)session.getAttribute("username");
        /*PrintWriter out = response.getWriter();

    	out.println(username);*/
        request.setAttribute("username", username);

        List < Ticket > listTicket = ticketDao.getAllTicket(username);
       
        request.setAttribute("listTicket", listTicket);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void pList(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	    	
    	        

				List < Ticket > listTicket = ticketDao.getPendingTicket();
    	       
    	        request.setAttribute("listTicket", listTicket);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("mList.jsp");
    	        dispatcher.forward(request, response);
    	    }
    private void rForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
			int rid = Integer.parseInt(request.getParameter("rid"));
	
        Ticket existingTicket = ticketDao.getTicket(rid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("ticket", existingTicket);
        dispatcher.forward(request, response);

    }

    private void insertTicket(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String user = request.getParameter("user");
        String type = request.getParameter("type");
        String amount = request.getParameter("amount");
        String description = request.getParameter("description");
        String timestamp = request.getParameter("timestamp");
        String status = request.getParameter("status");
        Ticket newTicket = new Ticket(user, type, amount, description, timestamp, status);
        ticketDao.saveTicket(newTicket);
        response.sendRedirect("list");
    }

    private void updateTicket(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        String user = request.getParameter("user");
        String type = request.getParameter("type");
        String amount = request.getParameter("amount");
        String description = request.getParameter("description");
        String timestamp = request.getParameter("timestamp");
        String status = request.getParameter("status");

        Ticket ticket = new Ticket(rid, user, type, amount, description, timestamp, status);
        ticketDao.updateTicket(ticket);
        response.sendRedirect("list");
    }

    private void deleteTicket(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        ticketDao.deleteTicket(rid);
        response.sendRedirect("list");
    }
}