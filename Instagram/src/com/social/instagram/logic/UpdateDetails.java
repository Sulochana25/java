package com.social.instagram.logic;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	ServletContext context;

	public UpdateDetails() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			context = getServletContext();
			con = (Connection) context.getAttribute("connection");

			response.setContentType("text/html");
			DiskFileItemFactory factory = new DiskFileItemFactory();

			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			ServletFileUpload upload = new ServletFileUpload(factory);

			PreparedStatement preparedStatement = null;
			PreparedStatement UpdateStatement = con.prepareStatement(
					" update SnapGGkUsers SET emailid=?,password = ?,firstname=?,lastname=? WHERE id = ?");

			String fileName = "";
			String emailid = "";
			String password = "";
			String firstname = "";
			String lastname = "";
			String date = "";
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					String name = item.getFieldName();

					if (name.equals("emailid")) {
						emailid += item.getString();
					} else if (name.equals("password")) {
						password += item.getString();
					} else if (name.equals("firstname")) {
						firstname += item.getString();
					} else if (name.equals("lastname")) {
						lastname += item.getString();
					} else if (name.equals("dob")) {
						date += item.getString();

						if (date.equals("")) {
							date += "1990-01-01";
						}

					}
				} else {

					fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);

					if (fileName == "" || fileName == null) {
						preparedStatement = con.prepareStatement(
								" update userDetails SET emailid=?,password = ?,firstname=?,lastname=?,DoB=? WHERE userid = ?");
						preparedStatement.setInt(6, (int) request.getSession().getAttribute("userid"));

					} else {
						preparedStatement = con.prepareStatement(
								" update userDetails SET emailid=?,password = ?,firstname=?,lastname=?,DoB=?,displayPicture=? WHERE userid = ?");
						File file = new File("E:\\Advanced_Java\\Instagram\\WebContent\\images\\"
								+ item.getName().substring(item.getName().lastIndexOf("\\") + 1));
						preparedStatement.setInt(7, (int) request.getSession().getAttribute("userid"));
						item.write(file);
						preparedStatement.setString(6, fileName);
					}

				}
			}

			preparedStatement.setString(1, emailid);
			UpdateStatement.setString(1, emailid);

			preparedStatement.setString(2, password);
			UpdateStatement.setString(2, password);

			preparedStatement.setString(3, firstname);
			UpdateStatement.setString(3, firstname);

			preparedStatement.setString(4, lastname);
			UpdateStatement.setString(4, lastname);

			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			java.sql.Date data = new java.sql.Date(date1.getTime());
			preparedStatement.setDate(5, data);

			UpdateStatement.setInt(5, (int) request.getSession().getAttribute("userid"));

			preparedStatement.executeUpdate();
			UpdateStatement.executeUpdate();

			response.sendRedirect("/Instagram/userEditDetails.jsp");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
