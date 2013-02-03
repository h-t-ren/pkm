package com.huaxinshengyuan.pkm.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.StartNode;
@SuppressWarnings("serial")
@XmlRootElement(name="userTag")
public class UserTag extends PKMRelation{

	@StartNode private User user;
	@Indexed @EndNode private Tag tag;
	private Integer freq;
	private Date created;
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getFreq() {
		return freq;
	}
	public void setFreq(Integer freq) {
		this.freq = freq;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
