package servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;
import jakarta.servlet.RequestDispatcher;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.Bean01a_datenupdate;

/**
 * Servlet implementation class Servlet02datenupdate
 */
@WebServlet("/Servlet01a_datenupdate")
public class Servlet01a_datenupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Aktualisierung der Daten in einer DB und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		Bean01a_datenupdate newform = new Bean01a_datenupdate();
		newform.setId(Long.valueOf(request.getParameter("id")));
		newform.setEmail(request.getParameter("email"));
		newform.setPassword(request.getParameter("password"));
		
		// DB-Zugriff
		persist(newform);
		
		// Scope "Request"
		request.setAttribute("form", newform);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/01a_datenupdate.jsp");
		dispatcher.forward(request, response);
	}
    
    private void persist(Bean01a_datenupdate newform) throws ServletException {
		// DB-Zugriff
		try (Connection con = ds.getConnection();
		     PreparedStatement pstmt = con.prepareStatement(
		    		"UPDATE customer "
		    		+ "SET email = ?, password_string = ? "
		     		+ "WHERE id = ?")) {
			
			pstmt.setString(1, newform.getEmail());
			pstmt.setString(2, newform.getPassword());
			pstmt.setLong(3, newform.getId());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
