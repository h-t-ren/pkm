package com.huaxinshengyuan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping(value = "/knowledge")
public class KnowledgeController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String populateDashboard( Model model) {
		return "new/dashboard";
	}
	@RequestMapping(value = "/node/new", method = RequestMethod.GET)
	public String populateKnowledgeForm( Model model) {
		return "new/knowledgeNode";
	}
	@RequestMapping(value = "/node/new", method = RequestMethod.POST)
	public String saveKnowledge(@RequestParam(value = "content", required = false) String content, Model model) {
		System.out.println(content);
		model.addAttribute("content", content);
		return "new/knowledgeNode";
	}
}
