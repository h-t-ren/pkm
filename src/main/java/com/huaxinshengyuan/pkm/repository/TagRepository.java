package com.huaxinshengyuan.pkm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.pkm.domain.Tag;

public interface TagRepository extends GraphRepository<Tag>,NamedIndexRepository<Tag>,
RelationshipOperationsRepository<Tag> {
	public Page<Tag> findByTagLike(String tag, Pageable page);
}
