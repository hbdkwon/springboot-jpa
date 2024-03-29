package com.hbdkwon.webservice.web;

import com.hbdkwon.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @GetMapping("/react")
    public String react() {
        return "react";
    }

    @GetMapping("/angular")
    public  String angular() {
        return "angular";
    }
}
