package com.spring.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeBlogService;

@Controller
public class CodeBlogController {
	@Autowired
	CodeBlogService service;

	@GetMapping("/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = service.findAll();
		mv.addObject("posts", posts);
		return mv;
	}

	@GetMapping("/posts/{id}")
	public Object getPostById(@PathVariable long id) {
		ModelAndView mv = new ModelAndView();
		if (!service.findById(id).isPresent()) {
			return "redirect:/posts";
		}
		Post post = service.findById(id).get();
		mv.setViewName("postDetails");
		mv.addObject("post", post);
		return mv;
	}
}
