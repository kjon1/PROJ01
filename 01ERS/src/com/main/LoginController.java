package com.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;


@WebServlet("/login")
public class LoginController  extends HttpServlet{
	private static final long serialVersionUID = 1 ;
    private EmployeeDao loginDao;

    public void init() {
        loginDao = new EmployeeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("login.jsp");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();

        

        if (loginDao.validate(username, password)) {
        	HttpSession session =request.getSession();
        	session.setAttribute("username", username);
        	
            request.getRequestDispatcher("user-list.jsp").forward(request, response);
        } else {
        	request.setAttribute("error","Oops: username or password is invalid.");
        	
        	RequestDispatcher rd =request.getRequestDispatcher("/login.jsp");            
        	rd.include(request, response);

        	
        }

            
    }

	private void alert() throws FileNotFoundException, UnsupportedEncodingException{
		// TODO Auto-generated method stub
        
		

		
	}
}


