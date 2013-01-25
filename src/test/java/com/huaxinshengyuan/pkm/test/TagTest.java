package com.huaxinshengyuan.pkm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.huaxinshengyuan.pkm.domain.Tag;
import com.huaxinshengyuan.pkm.repository.TagRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional(readOnly=true)
public class TagTest {
	    private Logger log = LoggerFactory.getLogger(this.getClass());
	 
	    @Autowired private TagRepository tagRepository;

	    @Test
	    public void findTags()
	    {
	    	  Page<Tag> tags = tagRepository.findByTagLike("你好", new PageRequest(0, 20));
	    	  for(Tag tag:tags)
	    	  {
	    		  log.debug("---------find: " + tag.getTag());
	    	  }
	    }
	
}
