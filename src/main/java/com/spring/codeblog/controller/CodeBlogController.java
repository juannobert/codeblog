package com.spring.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeBlogService;

@Controller
public class CodeBlogController {
	@Autowired
	CodeBlogService service;
	
	@GetMapping("/")
	public ModelAndView getPosts() {
		ModelAndView mv =  new ModelAndView("posts");
		List<Post> posts = service.findAll();
		mv.addObject("post",posts);
		return mv;
	}
}
