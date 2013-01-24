package com.huaxinshengyuan.pkm.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.StartNode;


@SuppressWarnings("serial")
public class TagSimilarity extends PKMRelation{
	
	@StartNode Tag t1;
	@EndNode Tag t2;
	private float similarity;

	public Tag getT1() {
		return t1;
	}
	public void setT1(Tag t1) {
		this.t1 = t1;
	}
	public Tag getT2() {
		return t2;
	}
	public void setT2(Tag t2) {
		this.t2 = t2;
	}
	public float getSimilarity() {
		return similarity;
	}
	public void setSimilarity(float similarity) {
		this.similarity = similarity;
	}
	
}
