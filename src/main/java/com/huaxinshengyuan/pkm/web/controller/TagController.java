package com.huaxinshengyuan.pkm.web.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huaxinshengyuan.pkm.domain.json.Tags;
import com.huaxinshengyuan.pkm.services.TagService;

@Controller
@RequestMapping(value = "/tag")
@Transactional(readOnly = true)
public class TagController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired private TagService tagService;

	@RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Tags findTags(@RequestParam(value = "query", required = false) String query) {
		Tags tags = new Tags();
		if (query == null) {

		} else {
			tags.setQuery(query);
			tags.getSuggestions().addAll(tagService.findByQuery(query));
		}
		return tags;
	}
}
