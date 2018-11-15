package org.PresentationModule;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CommonUtils.Constants;
import org.CommonUtils.SetBeanValues;
import org.CommonUtils.UserDetailsBean;
import org.ServiceModule.ServiceUpdateUserDetails;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateDetails() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ServletContext context = getServletContext();
			int userid = (Integer) context.getAttribute(Constants.USERID);

			UserDetailsBean userDetailsBean = (UserDetailsBean) context.getAttribute(Constants.USERDETAILSBEAN);

			DiskFileItemFactory factory = new DiskFileItemFactory();

			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			ServletFileUpload upload = new ServletFileUpload(factory);

			String fileName = "";
			String emailid = "";
			String password = "";
			String firstname = "";
			String lastname = "";
			String nationality = "";
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();

			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					String name = item.getFieldName();

					if (name.equals(Constants.EMAILID)) {
						emailid += item.getString();
					} else if (name.equals(Constants.USERPASSWORD)) {
						password += item.getString();
					} else if (name.equals(Constants.FIRSTNAME)) {
						firstname += item.getString();
					} else if (name.equals(Constants.LASTNAME)) {
						lastname += item.getString();
					} else if (name.equals(Constants.COUNTRY)) {
						nationality += item.getString();

					}
				} else {

					fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);

					if (fileName == "" || fileName == null) {

					} else {
						File file = new File(
								Constants.IMAGE_PATH + item.getName().substring(item.getName().lastIndexOf("\\") + 1));
						item.write(file);
						userDetailsBean.setDisplayPicture(fileName);
					}
				}
			}

			userDetailsBean = (UserDetailsBean) SetBeanValues.setBeanValue(userDetailsBean, firstname, lastname,
					emailid, password, fileName, nationality);

			context.setAttribute(Constants.USERDETAILSBEAN, userDetailsBean);
			int isDetailsUpdated = ServiceUpdateUserDetails.getInstance().updateUserDetails(userid, userDetailsBean);

			if (isDetailsUpdated == -1) {
				request.setAttribute("message", "Details cannot be uploaded right now");
				request.getRequestDispatcher("exception.jsp").forward(request, response);
				response.sendRedirect("exception.jsp");
			}

			response.sendRedirect("userEditDetails.jsp");

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
