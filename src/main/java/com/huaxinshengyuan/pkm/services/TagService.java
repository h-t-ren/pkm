package com.huaxinshengyuan.pkm.services;

import com.huaxinshengyuan.pkm.domain.Tag;



public interface TagService {

	public void addSimmilarity(Tag t1,Tag t2, float similarity);
}
