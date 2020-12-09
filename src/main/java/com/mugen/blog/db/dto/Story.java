package com.mugen.blog.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Id;


@Entity
@Table(name = "story_table")
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "story_id")
	private Integer id;
	/*
	 * @Column(name = "user_id") private Integer user_id;
	 */
	@Column(nullable = false, unique = true, name = "story_title")
	private String title;
	@Column(nullable = false , unique = true, name = "story_content")
	private String content;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users users;
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Story() {
		super();
	}
	
	public Story(Integer user_id, String title, String content) {
		super();
		//this.user_id = user_id;
		this.title = title;
		this.content = content;
	}
	
	public Story(Integer id, Integer user_id, String title, String content) {
		super();
		this.id = id;
		//this.user_id = user_id;
		this.title = title;
		this.content = content;
	}

	/*
	 * public Integer getUser_id() { return user_id; }
	 * 
	 * public void setUser_id(Integer user_id) { this.user_id = user_id; }
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
}