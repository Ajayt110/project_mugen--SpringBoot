package com.mugen.blog.db.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mugen.blog.db.dto.Users;
import com.mugen.blog.db.repository.UserRepository;

@Service
@Repository("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users save(Users users) {
		try {
			return userRepository.save(users);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Users update(Users users) {
		try {
			return userRepository.save(users);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Users users) {
		try {
			userRepository.delete(users);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			userRepository.deleteById(id);;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Users get(Integer id) {
		try {
			return userRepository.getOne(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Users get(String email) {
		try {
			return userRepository.findByEmail(email);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Users> get() {
		try {
			return userRepository.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Users get(String email, String password) {
		try {
			return userRepository.findByEmailAndPassword(email, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
