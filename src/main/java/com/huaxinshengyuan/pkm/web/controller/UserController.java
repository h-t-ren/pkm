package com.huaxinshengyuan.pkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.huaxinshengyuan.pkm.domain.User;
import com.huaxinshengyuan.pkm.services.UserService;

@Controller @RequestMapping(value = "/user")
public class UserController {

	@Autowired private UserService userService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String populateList( Model model) {
		model.addAttribute("users",userService.findUsers());
		
		return "/user/list";
	}
	@RequestMapping(value = "/form/{userid}", method = RequestMethod.GET)
	public String populateUserForm(@PathVariable("userid") long userid, Model model) {
		User user;
		if(userid==-1)
		{
			user = new User();
		}
		else
		{
			user = userService.findById(userid);
		}
		model.addAttribute("user", user);
		return "/user/form";
	}
	@RequestMapping(value = "/form/{userid}", method = RequestMethod.POST) @Transactional
	public String saveKnowledge(@ModelAttribute User user, Model model) {
		userService.register(user);
		return "redirect:/user/list";
	}
}
