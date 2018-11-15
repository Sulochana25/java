package com.ggktech.FormFill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class UserController {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	UserDAO userDAO = (UserDAO) context.getBean("userDAO");

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/user")
	public String user(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "form1";
	}

	@RequestMapping(value = "/formPage1", method = RequestMethod.POST)
	public String formPage1(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "form1";
		}
		model.addAttribute(user);
		return "form2";
	}

	@RequestMapping(value = "/formPage2", method = RequestMethod.POST)
	public String formPage2(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, ModelMap model) {

		model.addAttribute(user);
		userDAO.addUser(user);
		return "userInfo";
	}
}