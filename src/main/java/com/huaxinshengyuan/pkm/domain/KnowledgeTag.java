package com.huaxinshengyuan.pkm.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.StartNode;
@SuppressWarnings("serial")
public class KnowledgeTag extends PKMRelation{

	@StartNode private KnowledgeNode knowledgeNode;
	@Fetch @EndNode private Tag tag;
	private int seq;
	private float importance;

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public float getImportance() {
		return importance;
	}
	public void setImportance(float importance) {
		this.importance = importance;
	}
	public KnowledgeNode getKnowledgeNode() {
		return knowledgeNode;
	}
	public void setKnowledgeNode(KnowledgeNode knowledgeNode) {
		this.knowledgeNode = knowledgeNode;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
}
