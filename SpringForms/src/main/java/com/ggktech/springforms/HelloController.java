package com.ggktech.springforms;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB

	@RequestMapping("uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("uploadform");
	}

	@RequestMapping(value = "savefile", method = RequestMethod.POST)
	public ModelAndView saveimage(@RequestParam CommonsMultipartFile file, HttpSession session) throws Exception {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		String uploadPath = "E:\\Advanced_Java\\SpringForms\\src\\main\\webapp\\images";
		System.out.println(uploadPath);

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(uploadPath + File.separator + file.getOriginalFilename())));
		stream.write(bytes);
		stream.flush();
		stream.close();

		return new ModelAndView("uploadform", "filesuccess", "File successfully saved!");
	}
}