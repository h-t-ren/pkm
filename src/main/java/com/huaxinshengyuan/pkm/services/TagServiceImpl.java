package com.huaxinshengyuan.pkm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.pkm.domain.KnowledgeNode;
import com.huaxinshengyuan.pkm.domain.RelationType;
import com.huaxinshengyuan.pkm.domain.Tag;
import com.huaxinshengyuan.pkm.domain.TagSimilarity;
import com.huaxinshengyuan.pkm.repository.TagRepository;

@Service("tagService") @Transactional(readOnly=true)
public class TagServiceImpl implements TagService {
	@Autowired private Neo4jOperations template;
	@Autowired private TagRepository tagRepository;

	@Override @Transactional
	public void addSimmilarity(Tag t1, Tag t2, float similarity) {
		TagSimilarity tagSimilarity =template.createRelationshipBetween(t1, t2, TagSimilarity.class, RelationType.TagSimilarity, false);
		tagSimilarity.setSimilarity(similarity);
		template.save(tagSimilarity);
		
	}

	@Override
	public List<Tag> findAllTags() {
		return ListConvertertUtil.convert(tagRepository.findAll());
	}

	@Override @Transactional
	public void save(Tag tag) {
		Tag t =findTag(tag.getTag());
		if(t==null)
		{
			tagRepository.save(tag);
		}
		else
		{
			t.setFreq(t.getFreq()+1);
			tagRepository.save(tag);
		}

	}

	@Override
	public List<String> findByQuery(String query) {
		List<String> lst = new ArrayList<String>();
		 EndResult<Tag> tags= tagRepository.findAllByQuery("tag", "tag", "*"+query+"*");
		 for(Tag tag:tags)
		 {
			 lst.add(tag.getTag());
		 }
		
		return lst;
	}

	@Override
	public Tag findTag(String tag) {
		 return tagRepository.findByPropertyValue("tag", tag);
	}
	

}
