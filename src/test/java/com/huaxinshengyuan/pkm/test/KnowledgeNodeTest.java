package com.huaxinshengyuan.pkm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.huaxinshengyuan.pkm.domain.KnowledgeNode;
import com.huaxinshengyuan.pkm.repository.KnowledgeNodeRepository;
import com.huaxinshengyuan.pkm.services.KnowledgeNodeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional(readOnly=true)
public class KnowledgeNodeTest {
	    private Logger log = LoggerFactory.getLogger(this.getClass());
	 
	    @Autowired private KnowledgeNodeService knowledgeNodeService;
	    @Autowired private KnowledgeNodeRepository knowledgeNodeRepository;
	    @Autowired private Neo4jOperations template;
	    @Test
	    public void findKnowledgeNodes()
	    {
	    	EndResult<KnowledgeNode> nodes = 
	    			//template.lookup("knowledgeNode","name:*好* OR description:*好*").to(KnowledgeNode.class);
	    			//knowledgeNodeRepository.findAllByQuery("name","*好*");
	    			knowledgeNodeService.findAllbyQuery("hello");
	    	
	    	for(KnowledgeNode node:nodes)
	    	{
	    		log.debug("--- title:"+node.getName());
	    		log.debug("--- description:"+node.getDescription());
	    	}
	    }
	
}
