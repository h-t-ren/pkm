package com.huaxinshengyuan.pkm.domain;

import java.util.Collection;
import java.util.Collections;

import javax.validation.constraints.Size;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.support.index.IndexType;



@SuppressWarnings("serial")
public class Tag extends PKMNode {

   
    @Indexed(indexName="tag",fieldName="tag",indexType=IndexType.FULLTEXT)
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
		   Iterable<TagSimilarity> ts = tagSimilarities;
	       return ts == null ? Collections.<TagSimilarity>emptyList() : IteratorUtil.asCollection(ts);
	}
	public Integer getFreq() {
		return freq;
	}
	public void setFreq(Integer freq) {
		this.freq = freq;
	}

 
}
