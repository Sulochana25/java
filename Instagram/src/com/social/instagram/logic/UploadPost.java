package com.social.instagram.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class UploadPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	ServletContext context;
	FileOutputStream out = null;
	FileInputStream in = null;

	public UploadPost() {
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

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Parse the request
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into posted_pictures(userid,postdescription,pictureblob) values(?,?,?)");
			int userid = (int) request.getSession().getAttribute("userid");

			preparedStatement.setInt(1, userid);

			String description = "";
			String fileName = "";
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					description += item.getString();
					preparedStatement.setString(2, description);

				} else {
					fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
					File file = new File("E:\\Advanced_Java\\Instagram\\WebContent\\images\\"
							+ item.getName().substring(item.getName().lastIndexOf("\\") + 1));
					item.write(file);
				}
			}

			preparedStatement.setString(3, fileName);
			preparedStatement.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println(
					"<html><body><script>alert('Successfully uploaded!');window.location.href='UserProfile.jsp'; </script></body></html>");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
