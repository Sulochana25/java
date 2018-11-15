package org.PresentationModule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CommonUtils.Constants;
import org.CommonUtils.NewPostBean;
import org.ServiceModule.ServiceUploadUserPost;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadPost() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileOutputStream out = null;
		FileInputStream in = null;

		try {
			ServletContext context = getServletContext();

			DiskFileItemFactory factory = new DiskFileItemFactory();

			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			ServletFileUpload upload = new ServletFileUpload(factory);

			int userid = (Integer) context.getAttribute(Constants.USERID);

			String description = "";
			String fileName = "";
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					description += item.getString();

				} else {
					fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
					File file = new File(
							Constants.IMAGE_PATH + item.getName().substring(item.getName().lastIndexOf("\\") + 1));
					item.write(file);
				}
			}

			// NewPostBean newPostBean = NewPostBean.getInstance();
			NewPostBean newPostBean = new NewPostBean();
			newPostBean.setDescription(description);
			newPostBean.setPicture(fileName);

			context.setAttribute(Constants.NEWPOSTBEAN, newPostBean);
			int isPostUploaded = ServiceUploadUserPost.getInstance().uploadPost(userid, newPostBean);

			if (isPostUploaded == -1) {
				request.setAttribute("message", "Post cannot be uploaded right now");
				request.getRequestDispatcher("exception.jsp").forward(request, response);
				response.sendRedirect("exception.jsp");
			}

			response.sendRedirect("/PresentationModule/UserHomePage");

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
