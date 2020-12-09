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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mugen.blog.db.dto.Users;
import com.mugen.blog.db.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<Users>> getUser(){
		return  new ResponseEntity<List<Users>>(userService.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Users> saveUser(@RequestBody Users user){
		user= userService.save(user);
		if(user!=null)
			return new ResponseEntity<Users>(user, HttpStatus.CREATED);
		else 
			return new ResponseEntity<Users>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> get(@PathVariable("id") Integer id)
	{
		Users user = userService.get(id);
		if(user!=null)
			return new ResponseEntity<Users>(user, HttpStatus.CREATED);
		else 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with that id Doesn't exist");
	}
	
	
	@PutMapping
	public ResponseEntity<Users> update(@RequestBody Users user)
	{
		userService.update(user);
		if(user!=null)
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		else 
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Users> get(@RequestParam ("email")String email, @RequestParam ("password") String password,HttpSession session)
	{
		Users users = userService.get(email, password);
		if(users!= null) {
			session.setAttribute("email", email);
			return new ResponseEntity<Users>(users, HttpStatus.OK);
		}
		else 
	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with that email & password Doesn't exist");
			
		
	}

}
