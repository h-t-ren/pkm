package com.huaxinshengyuan.pkm.services;

import java.util.List;

import com.huaxinshengyuan.pkm.domain.Tag;



public interface TagService {

	public void addSimmilarity(Tag t1,Tag t2, float similarity);
	
	public List<Tag> findAllTags();
	public void save(Tag tag);
}
