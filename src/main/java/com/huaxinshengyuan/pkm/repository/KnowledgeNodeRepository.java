package com.huaxinshengyuan.pkm.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.pkm.domain.KnowledgeNode;
import com.huaxinshengyuan.pkm.domain.RelationType;
import com.huaxinshengyuan.pkm.domain.User;


public interface KnowledgeNodeRepository extends GraphRepository<KnowledgeNode>,NamedIndexRepository<KnowledgeNode>,
        RelationshipOperationsRepository<KnowledgeNode> {
	public Page<KnowledgeNode> findByDescriptionLike(String description, Pageable page);
	
	   @Query("start user=node({0})"+
			    " match user-[r:"+RelationType.UserOwnedKnowledge+"]->k return k")
	    public List<KnowledgeNode> findKnowledgeNodes(User u);
}
