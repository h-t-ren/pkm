package com.huaxinshengyuan.pkm.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.huaxinshengyuan.pkm.domain.KnowledgeNode;
import com.huaxinshengyuan.pkm.domain.Tag;
import com.huaxinshengyuan.pkm.domain.User;
import com.huaxinshengyuan.pkm.services.KnowledgeNodeService;
import com.huaxinshengyuan.pkm.services.PkmUserDetailsService;
import com.huaxinshengyuan.pkm.services.TagService;


@Controller @RequestMapping(value = "/knowledge")
@Transactional(readOnly=true)
public class KnowledgeController {

	@Autowired private KnowledgeNodeService knowledgeNodeService;
	@Autowired private PkmUserDetailsService userDetailsService;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Value("#{prop['uploaded_file_path']}") private String filePath;
	@Autowired private TagService tagService;
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String populateDashboard(Model model) {
		return "knowledge/dashboard";
	}
	@RequestMapping(value = "/node/{nodeId}/edit", method = RequestMethod.GET)
	public String populateKnowledgeForm(@PathVariable("nodeId") long nodeId, Model model) {
		populateKnowledge(nodeId, model);
		String tags="";
		int i=0;
		//temporary solution
		for(Tag tag: tagService.findAllTags())
		{
			tags+=(i==0)?tag.getTag():","+tag.getTag();
			i++;
		}
		
		model.addAttribute("tags", tags);
		
		return "knowledgeNode/form";
	}
	@RequestMapping(value = "/node/{nodeId}/view", method = RequestMethod.GET)
	public String populateKnowledgeView(@PathVariable("nodeId") long nodeId, Model model) {
		populateKnowledge(nodeId, model);
		return "knowledgeNode/view";
	}
	
	@RequestMapping(value = "/node/{nodeId}/edit", method = RequestMethod.POST)
	@Transactional
	public String saveKnowledge(
			@RequestParam(value = "save", required = false) String save,
			@RequestParam(value = "cancel", required = false) String cancel,
			@PathVariable("nodeId") long nodeId,
			@ModelAttribute KnowledgeNode knowledgeNode,
			@RequestParam(value="files[]", required=false) MultipartFile[] files,
			Model model)throws Exception {
		if (cancel != null) {
			return "redirect:/knowledge/dashboard";
		}
		User user = userDetailsService.getUserFromSession();
		if(nodeId!=-1) //modify existing knowledge node
		{
			knowledgeNode.setId(nodeId);
			knowledgeNode.setLastModified(new Date());
			knowledgeNode.setModifier(user);
		}
		else  //create new knowledge node
		{
			knowledgeNode.setCreated(new Date());
			knowledgeNode.setUser(user);
		}
		for (MultipartFile file : files) {
			
			if(!file.getOriginalFilename().isEmpty())
			{
				log.debug("---file: " +file.getOriginalFilename() +"---");
				File disFile = new File(filePath+file.getOriginalFilename());
		 	    file.transferTo(disFile);
			}
			
		}
		knowledgeNodeService.save(knowledgeNode);
		log.debug("---knowledge id: " + knowledgeNode.getId());
		
		
		return "redirect:/knowledge/dashboard";
	}
	

	public void populateKnowledge(long nodeId, Model model) {
		KnowledgeNode knowledgeNode;
		if(nodeId==-1)
		{
			 knowledgeNode = new KnowledgeNode();	
		}
		else
		{
			knowledgeNode = knowledgeNodeService.find(nodeId);
		}
		model.addAttribute("knowledgeNode", knowledgeNode);
	}
	
}
