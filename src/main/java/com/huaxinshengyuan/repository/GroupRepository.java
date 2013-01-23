package com.huaxinshengyuan.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

import com.huaxinshengyuan.domain.Group;

public interface GroupRepository extends GraphRepository<Group>,NamedIndexRepository<Group>,
        RelationshipOperationsRepository<Group> {
   
}
