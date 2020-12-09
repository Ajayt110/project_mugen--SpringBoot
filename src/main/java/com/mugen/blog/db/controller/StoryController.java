package com.mugen.blog.db.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mugen.blog.db.dto.Story;
import com.mugen.blog.db.dto.Users;
import com.mugen.blog.db.services.StoryService;
import com.mugen.blog.db.services.UserService;

@RestController
@RequestMapping("/story")
@CrossOrigin(origins = "*")
public class StoryController {

	@Autowired
	private StoryService storyService;
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Story>> getStory() {
		return new ResponseEntity<List<Story>>(storyService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Story> saveStory(@RequestBody Story story, HttpSession session) {

		if (session.getAttribute("email") != null) {

			Users users = userService.get(session.getAttribute("email").toString());
			story.setUsers(users);
			story = storyService.save(story);
			if (story != null)
				return new ResponseEntity<Story>(story, HttpStatus.CREATED);
			else
				return new ResponseEntity<Story>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
			return new ResponseEntity<Story>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*
	 * @GetMapping("/{id}") public ResponseEntity<Story> get(@PathVariable("id")
	 * Integer id) { Story story = storyService.get(id); if(story!=null) return new
	 * ResponseEntity<Story>(story, HttpStatus.CREATED); else throw new
	 * ResponseStatusException(HttpStatus.NOT_FOUND,
	 * "Story with that id Doesn't exist"); }
	 */

	@GetMapping("/{title}")
	public ResponseEntity<Story> getByTitle(@PathVariable("title") String title) {
		Story story = storyService.getByTitle(title);
		if (story != null)
			return new ResponseEntity<Story>(story, HttpStatus.CREATED);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Story with that title Doesn't exist");
	}

	@PutMapping
	public ResponseEntity<Story> updateStory(@RequestBody Story story) {
		storyService.update(story);
		if (story != null)
			return new ResponseEntity<Story>(story, HttpStatus.OK);
		else
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
