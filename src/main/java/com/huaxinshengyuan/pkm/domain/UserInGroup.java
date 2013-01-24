package com.huaxinshengyuan.pkm.domain;

import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.StartNode;



@XmlRootElement(name="userInGroup")
@SuppressWarnings("serial")
public class UserInGroup extends PKMRelation{
	
	@StartNode private User user;
	@EndNode  private Group group;
	private UserType userType;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}


}
