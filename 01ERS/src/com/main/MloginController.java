package com.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

@WebServlet("/mLogin")
public class MloginController  extends HttpServlet{
	private static final long serialVersionUID = 1 ;
    private ManagerDao mLoginDao;

    public void init() {
        mLoginDao = new ManagerDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("mLogin.jsp");

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
           

        if (mLoginDao.validate(username, password)) {
        	HttpSession session =request.getSession();
        	session.setAttribute("username", username);
        	
            request.getRequestDispatcher("mHome.jsp").forward(request, response);
        } else {
        	request.setAttribute("error","Oops: username or password is invalid.");
        	
        	RequestDispatcher rd =request.getRequestDispatcher("/mLogin.jsp");            
        	rd.include(request, response);

        	
        }

            
    }

}


