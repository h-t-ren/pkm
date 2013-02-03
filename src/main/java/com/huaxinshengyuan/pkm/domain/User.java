package com.huaxinshengyuan.pkm.domain;

import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;

import java.util.Collection;
import java.util.Collections;

import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@XmlRootElement(name="user")
public class User extends PKMNode {

	@Indexed(indexName=FieldIndex.LOGIN, unique=true)
    private String login;
    @Indexed private String name;
	private String email;
    private String homePage;
    private String picUrl;
    private String address;
    private String renren;
    private String sinaBlog;
    private String facebook;
	private String password;
    private Role[] roles;
	private DynamicProperties dyn;
	@RelatedToVia(elementClass = UserTag.class, type = RelationType.UserOwnedTag, direction = Direction.OUTGOING)
	private Iterable<UserTag> userTags;
    @RelatedToVia(type=RelationType.UserInGroup,direction=Direction.OUTGOING,elementClass=UserInGroup.class)@Fetch
    private  Iterable<UserInGroup> userInGroups;
    public User() {}
    public User(String login, String name, String password, Role... role) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.roles = role;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
		this.login = login;
	}
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
		this.password = password;
	}
    public Role[] getRoles() {
        return roles;
    }
	public void setRoles(Role[] roles) {
		this.roles = roles;
	}
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRenren() {
		return renren;
	}
	public void setRenren(String renren) {
		this.renren = renren;
	}
	public String getSinaBlog() {
		return sinaBlog;
	}
	public void setSinaBlog(String sinaBlog) {
		this.sinaBlog = sinaBlog;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public DynamicProperties getDyn() {
		return dyn;
	}
	public void setDyn(DynamicProperties dyn) {
		this.dyn = dyn;
	}
	@Override
	 public String toString() {
	        return String.format("%s (%s)", name, login);
	 }
    
    public Collection<UserInGroup> getUserInGroups()
    {
	    Iterable<UserInGroup> ugs = userInGroups;
        return ugs == null ? Collections.<UserInGroup>emptyList() : IteratorUtil.asCollection(ugs);
    }

	public Collection<UserTag> getUserTags() {
	    Iterable<UserTag> alluserTagss = userTags;
        return alluserTagss == null ? Collections.<UserTag>emptyList() : IteratorUtil.asCollection(alluserTagss);
	}

}
