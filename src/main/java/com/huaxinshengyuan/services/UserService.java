package com.huaxinshengyuan.services;

import java.util.Collection;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.huaxinshengyuan.domain.Group;
import com.huaxinshengyuan.domain.User;
import com.huaxinshengyuan.domain.UserInGroup;
import com.huaxinshengyuan.domain.UserType;

public interface UserService {
	
	@Cacheable(value="usersCache")
	public Collection<User> findUsers();
	
	//@Cacheable(value="userCache", key="#id")
	public User findById(Long id);
	
	@CacheEvict(value="usersCache", allEntries=true)
	public void save(User user);
	
	public void register(User user);
	
	public  UserInGroup joinInGroup(User user,Group group,UserType userType);

	public void makeFriends(User u1,User u2);
	
	public List<User> findFriends(User u);
}
