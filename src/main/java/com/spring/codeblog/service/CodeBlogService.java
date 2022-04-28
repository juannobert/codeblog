package com.spring.codeblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;

@Service
public class CodeBlogService {
	
	@Autowired
	CodeBlogRepository repository;
	
	public Optional<Post> findById(long id) {
		return repository.findById(id);
	}
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post save(Post post) {
		return repository.save(post);
	}
	
	public void delete(Post post) {
		repository.delete(post);
		
	}
}
