package com.mugen.blog.db.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mugen.blog.db.dto.Story;
import com.mugen.blog.db.repository.StoryRepository;

@Service
@Repository("storyService")
public class StoryServiceImpl implements StoryService {

	@Autowired
	private StoryRepository storyRepository;
	
	@Override
	public Story save(Story story) {
		try {
			return storyRepository.save(story);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Story update(Story story) {
		try {
			return storyRepository.save(story);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Story story) {
		try {
			storyRepository.delete(story);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			storyRepository.deleteById(id);;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	@Override
	public Story get(Integer id) {
		try {
			return storyRepository.getOne(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/

	@Override
	public List<Story> get() {
		try {
			return storyRepository.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Story getByTitle(String title) {
		try {
			return storyRepository.findByTitle(title);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	


}
