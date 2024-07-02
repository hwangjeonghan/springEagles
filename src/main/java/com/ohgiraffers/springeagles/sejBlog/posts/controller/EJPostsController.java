package com.ohgiraffers.springeagles.sejBlog.posts.controller;

import com.ohgiraffers.springeagles.sejBlog.comment.service.EJCommentService;
import com.ohgiraffers.springeagles.sejBlog.posts.model.dto.EJPostsDTO;
import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.service.EJPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sej/blog")
public class EJPostsController {

    private final EJPostsService EJPostsService;
    private final EJCommentService EJCommentService;

    @Autowired
    public EJPostsController(EJPostsService EJPostsService, EJCommentService EJCommentService) {
        this.EJCommentService = EJCommentService;
        this.EJPostsService = EJPostsService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", EJPostsService.getAllPosts());
        return "sej_Blog/blogPost2";
    }

    @GetMapping
    public ModelAndView showPage(Model model, ModelAndView mv){
        List<EJPostsEntity> postList = EJPostsService.postsEntityList();

        // 잘하면 수정해야할 수도? "connectPage?"
        model.addAttribute("connectPage", "main");

        mv.addObject("postList", postList);
        mv.setViewName("sej_Blog/blogPost2");

        return mv;
    }

    @GetMapping("/addpost")
    public String addPost(Model model){
        return "sej_Blog/fragments/addPost";
    }

    @PostMapping("/addpost")
    public ModelAndView postAdd(ModelAndView mv, EJPostsDTO EJPostsDTO){

        // 등록시킬 데이터

        mv.setViewName("이동할 페이지");

        return mv;

    }



}
