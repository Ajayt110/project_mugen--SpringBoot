package com.mugen.blog.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mugen.blog.db.dto.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story,Integer> {

	public Story findByTitle(String title);
	
}