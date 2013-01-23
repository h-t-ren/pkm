package com.huaxinshengyuan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.domain.Group;
import com.huaxinshengyuan.repository.GroupRepository;

@Service("groupService") @Transactional(readOnly=true)
public class GroupServiceImpl implements GroupService {
	
	//@Autowired private Neo4jOperations template;
	
	@Autowired private GroupRepository groupRepository;

	@Override @Transactional
	public void save(Group group) {
		groupRepository.save(group);
	}

	

}
