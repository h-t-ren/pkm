package com.huaxinshengyuan.pkm.repository;

import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

import com.huaxinshengyuan.pkm.domain.RelationType;
import com.huaxinshengyuan.pkm.domain.User;


public interface UserRepository extends GraphRepository<User>,
        RelationshipOperationsRepository<User> {
   
    @Query("start user=node({0})"+
		    " match user-[r:"+RelationType.UserHasFriend+"]-f return f")
    public List<User> findFriends(User u);
}
