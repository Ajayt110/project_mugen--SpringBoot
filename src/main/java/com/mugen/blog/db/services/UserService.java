package com.mugen.blog.db.services;

import java.util.List;

import com.mugen.blog.db.dto.Users;

public interface UserService {
	
	public Users save(Users users);
	public Users update(Users users);
	public boolean delete(Users users);
	public boolean delete(Integer id);
	public Users get(Integer id);
	public Users get(String email);
	public List<Users> get();
	public Users get(String email, String password);
}
