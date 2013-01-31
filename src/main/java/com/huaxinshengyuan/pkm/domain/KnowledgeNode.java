package com.huaxinshengyuan.pkm.domain;
import java.util.Collection;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;
import org.springframework.data.neo4j.support.index.IndexType;

@SuppressWarnings("serial")
@XmlRootElement(name="knowledgeNode")
public class KnowledgeNode extends PKMNode {
	
	@Indexed(indexName="knowledgeNode",fieldName="name", indexType=IndexType.FULLTEXT) private String name;
    @Indexed(indexName="knowledgeNode",fieldName="description", indexType=IndexType.FULLTEXT) private String description;
    @Indexed(indexName="knowledgeNode",fieldName="note", indexType=IndexType.FULLTEXT) private String note;
    private Integer importance;
    private Date created;
    private Date lastModified;
    @RelatedTo(type=RelationType.UserOwnedKnowledge, direction = Direction.INCOMING)@Fetch
    private User user;
	@RelatedTo(type=RelationType.UserModifyKnowledgen, direction = Direction.INCOMING)@Fetch
    private User modifier;
	@RelatedToVia(elementClass = KnowledgeTag.class, type = RelationType.KnowledgeHasTag, direction = Direction.OUTGOING)
	private Iterable<KnowledgeTag> knowledgeTags;
	private String url;
	private DynamicProperties dyn;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getModifier() {
		return modifier;
	}
	public void setModifier(User modifier) {
		this.modifier = modifier;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public KnowledgeNode(){}
	public KnowledgeNode(String name)
	{
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public DynamicProperties getDyn() {
		return dyn;
	}
	public void setDyn(DynamicProperties dyn) {
		this.dyn = dyn;
	}
	public Collection<KnowledgeTag> getKnowledgeTags() {
		return IteratorUtil.asCollection(knowledgeTags);
	}
	public Integer getImportance() {
		return importance;
	}
	public void setImportance(Integer importance) {
		this.importance = importance;
	}

}
