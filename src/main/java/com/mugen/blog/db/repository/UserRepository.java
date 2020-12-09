package com.mugen.blog.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mugen.blog.db.dto.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

	public Users findByEmail(String email);
	public Users findByEmailAndPassword(String email,String password);
}
