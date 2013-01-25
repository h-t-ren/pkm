package com.huaxinshengyuan.pkm.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.pkm.domain.KnowledgeNode;


public interface KnowledgeNodeRepository extends GraphRepository<KnowledgeNode>,NamedIndexRepository<KnowledgeNode>,
        RelationshipOperationsRepository<KnowledgeNode> {
	public Page<KnowledgeNode> findByDescriptionLike(String description, Pageable page);
}
