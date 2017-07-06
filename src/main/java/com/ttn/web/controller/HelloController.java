package com.ttn.web.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ttn.web.dto.UserData;
import com.ttn.web.dto.editor.UserIdEditor;

@Controller
public class HelloController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}

	@RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
	public ModelAndView userData() {

		ModelAndView model = new ModelAndView();
		model.setViewName("userForm");
		model.addObject("fName", "ABC");
		model.addObject("lName", "XYZ");

		return model;

	}

	@RequestMapping(value = "/saveUserDetails", method = RequestMethod.POST)
	public ModelAndView saveUserData(@ModelAttribute UserData userData, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		if (bindingResult.hasErrors()) {
			model.setViewName("hello");
			List<String> messages = new ArrayList<String>();
			for (Object object : bindingResult.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					messages.add(messageSource.getMessage(fieldError, null));
				}
			}
			System.out.println("Date " + userData.getDob());
			model.addObject("errorMesg", messages);
			System.out.println("Error");
			return model;
		}
		System.out.println("Date " + userData.getDob());
		model.addObject("userData", userData);
		model.setViewName("userForm");
		return model;

	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(simpleDateFormat, false));

		webDataBinder.registerCustomEditor(String.class, "userId", new UserIdEditor());
	}

}