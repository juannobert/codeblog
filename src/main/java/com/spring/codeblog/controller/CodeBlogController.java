package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.dto.PostDto;
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
	@GetMapping("newpost")
	public String getNewPostForm(PostDto postDto) {
		return "newPost";
	}
	
	@PostMapping("newpost")
	public String savePost(@Valid PostDto postDto,BindingResult result,RedirectAttributes atributes) {
		if(result.hasErrors()) {
			atributes.addFlashAttribute("mensagem","Preencha todos os campos");
			return "redirect:/newpost";
		}
		Post post = new Post();
		BeanUtils.copyProperties(postDto, post);
		post.setData(LocalDate.now());
		service.save(post);
		return "redirect:/posts";
		
	}
	
	@GetMapping("/posts/delete/{id}")
	public String deletePost(@PathVariable long id) {
			Post post = service.findById(id).get();
			service.delete(post);
			return "redirect:/posts";
	}
}
