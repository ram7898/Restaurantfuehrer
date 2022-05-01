package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;

import beans.Bean01registrierung;

/**
 * Servlet implementation class Servlet01registrierung
 */

@WebServlet("/servlet01registrierung")
public class Servlet01registrierung extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");

		//zusammengehöriger Bean Name einfügen
		Bean01registrierung form = new Bean01registrierung();
		form.setEmail(request.getParameter("email"));
		form.setPassword(request.getParameter("password"));
		form.setAnmerkung(request.getParameter("anmerkung"));

		// DB-Zugriff
		persist(form);

		// Scope "Session"
		//final HttpSession session = request.getSession();
		//session.setAttribute("form", form);

		// Scope "Request"
		request.setAttribute("form", form);

		// Weiterleiten entweder über Redirect oder Forward (hier so mit Forward)
		// jsp-Seitenname richtig angeben + PFAD!
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/01_registrierung_ausgabe.jsp");
		dispatcher.forward(request, response);

	}

	private void persist(Bean01registrierung form) throws ServletException {
		// DB-Zugriff
		//Primärschlüssel -> StringArray, weil es bei einem zusammengesetzten Primärschlüssel mehrere Werte sein könnten
		String[] generatedKeys = new String[] {"id"}; // Name der Spalte(n), die automatisch generiert wird(werden)

		//try with resources -> try() -> hier werden 2 Quellen geöffnet: Connection & PreparedStatement
		try (Connection con = ds.getConnection();
				/* final Statement stmt = con.createStatement() */
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO kunden (email,password_string,anmerkung) VALUES (?,?,?)",
						generatedKeys)) {

			// Zugriff über Klasse java.sql.Statement
			// -> zu gefährlich, wegen sql injection -> man könnte im formularfeld 
			//"; drop table kunden;" eingeben, dann würde die tabelle durch eine eingabe des kunden gelöscht 
			//werden
			/*
			 * stmt.executeUpdate("INSERT INTO employees (first,last,age) VALUES ('" +
			 * 					form.getFirstname() + "','" + 
			 * 					form.getLastname() + "','" + 
			 * 					form.getAge() +
			 * "')" );
			 */
			
			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, form.getEmail());
			pstmt.setString(2, form.getPassword());
			pstmt.setString(3, form.getAnmerkung());
			pstmt.executeUpdate();

			// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					form.setId(rs.getLong(1));
					// die 1 bezieht sich auf das StringArray in Zeile 70 bei den generatedKeys
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}