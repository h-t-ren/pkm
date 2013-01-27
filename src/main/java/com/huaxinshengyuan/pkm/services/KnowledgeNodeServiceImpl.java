package com.huaxinshengyuan.pkm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.pkm.domain.KnowledgeNode;
import com.huaxinshengyuan.pkm.domain.KnowledgeTag;
import com.huaxinshengyuan.pkm.domain.RelationType;
import com.huaxinshengyuan.pkm.domain.Tag;
import com.huaxinshengyuan.pkm.repository.KnowledgeNodeRepository;



@Service("knowledgeNodeService") @Transactional(readOnly=true)
public class KnowledgeNodeServiceImpl implements KnowledgeNodeService {
	
	@Autowired private KnowledgeNodeRepository knowledgeNodeRepository;
	@Autowired private Neo4jOperations template;
	
	@Override @Transactional
	public void save(KnowledgeNode knowledgeNode) {
		knowledgeNodeRepository.save(knowledgeNode);

	}

	@Override @Transactional
	public void addTag(KnowledgeNode knowledgeNode, Tag tag, int seq,
			float importance) {
		KnowledgeTag knowledgeTag =template.createRelationshipBetween(knowledgeNode, tag, KnowledgeTag.class, RelationType.KnowledgeHasTag,false);
		knowledgeTag.setSeq(seq);
		knowledgeTag.setImportance(importance);
		template.save(knowledgeTag);
		tag.setFreq(tag.getFreq()+1);
		template.save(tag);
	}

	@Override
	public KnowledgeNode find(long id) {
		return knowledgeNodeRepository.findOne(id);
	}

	@Override
	public EndResult<KnowledgeNode> findAllbyQuery(String query) {
		return knowledgeNodeRepository.findAllByQuery("knowledgeNode", "name:*"+query+"* OR description:*"+query+"*"+"* OR note:*"+query+"*");
		
	}



}
