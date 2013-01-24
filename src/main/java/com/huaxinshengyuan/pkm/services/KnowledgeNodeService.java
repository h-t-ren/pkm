package com.huaxinshengyuan.pkm.services;

import com.huaxinshengyuan.pkm.domain.KnowledgeNode;
import com.huaxinshengyuan.pkm.domain.Tag;



public interface KnowledgeNodeService {
	
	public void save(KnowledgeNode knowledgeNode);
	public void addTag(KnowledgeNode knowledgeNode,Tag tag, int seq, float importance);

}
