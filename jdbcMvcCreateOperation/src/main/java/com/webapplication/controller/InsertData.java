package com.webapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
  



@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/project")
private DataSource dataSource;       
    
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String param = request.getParameter("page");
		if(param.equals("insertdata")) {
			getServletContext().getRequestDispatcher("/insertdata.jsp").forward(request, response);
		}
		
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("starting");
		try {
			//initialize the database
			Connection con= DBConnect.initializeDatabase();
			
			//Create a SQL query to insert data into table1 table
			//table1 table consist of two columns, so two '?' is used
			PreparedStatement st= con.prepareStatement("insert into second values(?,?)");
			// second is y table name, u have to enter ur table name
			//For the first parameter
			//get the data using request object
			// sets the data to st pointer
			st.setInt(1, Integer.valueOf(request.getParameter("sid")));
			//st.setString(1, request.getParameter("sid"));
			//Same for second parameter
			st.setString(2, request.getParameter("sname"));
			
			//Execute the insert command using executeUpdate()
            // to make changes in database
			st.executeUpdate();
			
			//Close all the connection
			st.close();
			con.close();
			
			//Get a writer pointer
			// to display the successful result
			PrintWriter out = response.getWriter(); //import it from java.io
			out.println("<html><body><b>Successfully Inserted"+"</b></body></html>");
			
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}