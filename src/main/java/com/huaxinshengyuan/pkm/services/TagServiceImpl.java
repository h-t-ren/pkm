package com.huaxinshengyuan.pkm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
		tagRepository.save(tag);
		
	}
	

}
