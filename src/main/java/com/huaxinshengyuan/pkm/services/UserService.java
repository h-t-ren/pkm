package com.huaxinshengyuan.pkm.services;

import java.util.Collection;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.huaxinshengyuan.pkm.domain.Group;
import com.huaxinshengyuan.pkm.domain.KnowledgeNode;
import com.huaxinshengyuan.pkm.domain.Tag;
import com.huaxinshengyuan.pkm.domain.User;
import com.huaxinshengyuan.pkm.domain.UserInGroup;
import com.huaxinshengyuan.pkm.domain.UserType;

public interface UserService {
	
	@Cacheable(value="usersCache")
	public Collection<User> findUsers();
	
	//@Cacheable(value="userCache", key="#id")
	public User findById(Long id);
	
	@CacheEvict(value="usersCache", allEntries=true)
	public void save(User user);
	
	public void register(User user);
	
	public  UserInGroup joinInGroup(User user,Group group,UserType userType);
	public void addTag(User user,Tag tag);
	public void makeFriends(User u1,User u2);
	
	public List<User> findFriends(User u);
}
