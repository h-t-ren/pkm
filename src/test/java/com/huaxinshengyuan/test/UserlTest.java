package com.huaxinshengyuan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.GraphDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.node.Neo4jHelper;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.services.AppInitService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class UserlTest {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	 
	    @Autowired private AppInitService appInitService;

		@Autowired private GraphDatabaseService graphDatabaseService;

		@Rollback(false)
	  @BeforeTransaction
	    public void clearDatabase()
	    {
			Neo4jHelper.cleanDb(graphDatabaseService);
		
	   }

	    @Test  @Rollback(false)
	    public void populateDatabase()
	    {
	    	appInitService.initDb();
	    }
	
}
