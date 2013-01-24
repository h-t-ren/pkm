package com.huaxinshengyuan.pkm.domain;

import java.util.Collection;
import javax.validation.constraints.Size;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@SuppressWarnings("serial")
public class Tag extends KnowledgeNode {

   
	@Indexed  
	@Size(min=2,max=64) 
	private String tag;
	private Integer freq;
	
	@RelatedToVia(elementClass = TagSimilarity.class, type = RelationType.TagSimilarity, direction = Direction.BOTH)
	private Iterable<TagSimilarity> tagSimilarities;

	public Tag(){}
	public Tag(String tag){ this.tag=tag; this.freq=0;}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Collection<TagSimilarity> getTagSimilarities() {
		return IteratorUtil.asCollection(tagSimilarities);
	}
	public Integer getFreq() {
		return freq;
	}
	public void setFreq(Integer freq) {
		this.freq = freq;
	}

 
}
