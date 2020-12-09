package com.mugen.blog.db.services;

import java.util.List;

import com.mugen.blog.db.dto.Story;

public interface StoryService {
	
	public Story save(Story story);
	public Story update(Story story);
	public boolean delete(Story story);
	public boolean delete(Integer id);
	//public Story get(Integer id);
	public Story getByTitle(String title);
	public List<Story> get();
	
}
