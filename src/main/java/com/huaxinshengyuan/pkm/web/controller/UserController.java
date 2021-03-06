package com.huaxinshengyuan.pkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huaxinshengyuan.pkm.domain.User;
import com.huaxinshengyuan.pkm.services.UserService;

@Controller @RequestMapping(value = "/user")
@Transactional(readOnly=true)
public class UserController {

	@Autowired private UserService userService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String populateList( Model model) {
		model.addAttribute("users",userService.findUsers());
		
		return "/user/list";
	}
	@RequestMapping(value = "/form/{userId}", method = RequestMethod.GET)
	public String populateUserForm(@PathVariable("userId") long userId, Model model) {
		User user;
		if(userId==-1)
		{
			user = new User();
		}
		else
		{
			user = userService.findById(userId);
		}
		model.addAttribute("user", user);
		return "/user/form";
	}
	@RequestMapping(value = "/form/{userId}", method = RequestMethod.POST) @Transactional
	public String register(@ModelAttribute User user, Model model) {
		userService.register(user);
		return "redirect:/user/list";
	}
}
