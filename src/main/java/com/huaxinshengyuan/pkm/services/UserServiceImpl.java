package com.huaxinshengyuan.pkm.services;

import java.util.Collection;
import java.util.List;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.pkm.domain.Group;
import com.huaxinshengyuan.pkm.domain.RelationType;
import com.huaxinshengyuan.pkm.domain.User;
import com.huaxinshengyuan.pkm.domain.UserInGroup;
import com.huaxinshengyuan.pkm.domain.UserType;
import com.huaxinshengyuan.pkm.repository.UserRepository;


@Service("userService") @Transactional(readOnly=true)
public class UserServiceImpl implements UserService{
	
	@Autowired private Neo4jOperations template;
	
	@Autowired private UserRepository userRepository;
    private static final String SALT = "pkm";
	@Override
	public Collection<User> findUsers() {
		return IteratorUtil.asCollection(userRepository.findAll());
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override @Transactional 
	public void save(User user) {
			userRepository.save(user);
	}

	@Override  @Transactional 
	public void register(User user) {
		user.setPassword(encode(user.getPassword()));
		userRepository.save(user);
		
	}
    private String encode(String password) {
    	Md5PasswordEncoder md5 = new Md5PasswordEncoder();
    	String md5Hash = md5.encodePassword(password, SALT);
        return  md5Hash;
    }

	@Override  @Transactional 
	public UserInGroup joinInGroup(User user,Group group, UserType userType) {
		UserInGroup userInGroup = template.createRelationshipBetween(user, group, UserInGroup.class,  RelationType.UserInGroup, false);
		userInGroup.setUserType(userType);
		template.save(userInGroup);
		return userInGroup;
	}


	@Override
	public void makeFriends(User u1, User u2) {
		template.getNode(u1.getId()).createRelationshipTo(template.getNode(u2.getId()), DynamicRelationshipType.withName(RelationType.UserHasFriend));
	}

	@Override
	public List<User> findFriends(User u) {
		return userRepository.findFriends(u);
	}

}
