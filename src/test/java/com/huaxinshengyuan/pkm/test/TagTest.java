package com.huaxinshengyuan.pkm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.huaxinshengyuan.pkm.domain.Tag;
import com.huaxinshengyuan.pkm.repository.TagRepository;
import com.huaxinshengyuan.pkm.services.TagService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional(readOnly=true)
public class TagTest {
	    private Logger log = LoggerFactory.getLogger(this.getClass());
	 
	    @Autowired private TagRepository tagRepository;
	    @Autowired private TagService tagService;

	    @Test
	    public void findTags()
	    {
	    	  Page<Tag> tags = tagRepository.findByTagLike("你好", new PageRequest(0, 20));
	    	  for(Tag tag:tags)
	    	  {
	    		  log.debug("---------find: " + tag.getTag());
	    	  }
	    }
	    @Test
	    public void findTags1()
	    {
	    	 EndResult<Tag> tags= tagRepository.findAllByQuery("tag", "tag", "*你*");
			 for(Tag tag:tags)
			 {
				 log.debug("=================find: " + tag.getTag());
			 }
	    }
	    
	    
	    @Test
	    public void findTags2()
	    {
	    	 Tag tag=tagService.findTag("hello");
			 if(tag!=null)
			 {
				 log.debug("=================find tag: " + tag.getTag());
			 }
	    }
}
