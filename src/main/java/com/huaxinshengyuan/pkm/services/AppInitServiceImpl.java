package com.huaxinshengyuan.pkm.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.pkm.domain.Group;
import com.huaxinshengyuan.pkm.domain.Role;
import com.huaxinshengyuan.pkm.domain.Tag;
import com.huaxinshengyuan.pkm.domain.User;
import com.huaxinshengyuan.pkm.domain.UserType;


@Service("appInitService")
@Transactional
public class AppInitServiceImpl implements AppInitService {

	@Autowired
	private UserService userService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private TagService tagService;
	@Override @Transactional
	public void initDb() {
		createUsersAndGroups();
	
	}
	@Transactional
	public void createUsersAndGroups() {

		// Create Hongtao's family
		Group hongtaoGroup = new Group("hongtao_family", Role.ROLE_ADMIN);
		groupService.save(hongtaoGroup);

		User hongtao = new User("hongtao", "Hongtao Ren", "hongtao",
				Role.ROLE_ADMIN, Role.ROLE_USER);
		userService.register(hongtao);
		userService.joinInGroup(hongtao, hongtaoGroup, UserType.CREATOR);
		User yangyang = new User("yangyang", "Haoyang Ren", "yangyang", Role.ROLE_USER);
		userService.register(yangyang);

		userService.joinInGroup(yangyang, hongtaoGroup, UserType.USER);
		User yifang = new User("yifang", "Yifang Shi", "yifang", Role.ROLE_USER);
		userService.register(yifang);

		userService.joinInGroup(yifang, hongtaoGroup, UserType.USER);

		// Create Tieju's lab
		Group tiejuLab = new Group("tieju_lab", Role.ROLE_USER);
		groupService.save(tiejuLab);

		User tieju = new User("tieju", "Tieju Ma", "tieju", Role.ROLE_ADMIN,
				Role.ROLE_USER);
		userService.register(tieju);
		userService.joinInGroup(tieju, tiejuLab, UserType.CREATOR);
		User hongbin = new User("hongbin", "Hongbin Yan", "hongbin",
				Role.ROLE_USER);
		userService.register(hongbin);
		userService.joinInGroup(hongbin, tiejuLab, UserType.USER);

		// join Tieju's lab
		userService.joinInGroup(hongtao, tiejuLab, UserType.USER);
		// friends

		userService.makeFriends(yifang, hongtao);
		userService.makeFriends(yangyang, hongtao);
		userService.makeFriends(yangyang, tieju);
		userService.makeFriends(yangyang, yifang);
		
		Tag tag =new Tag();
		tag.setTag("hello");
		tag.setFreq(0);
		tagService.save(tag);
		
		Tag tag1 =new Tag();
		tag1.setTag("你好 woshi");
		tag1.setFreq(0);
		tagService.save(tag1);
		
		Tag tag2 =new Tag();
		tag2.setTag("hello world");
		tag2.setFreq(0);
		tagService.save(tag2);
	}
	
	
}
