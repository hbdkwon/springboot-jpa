package com.hbdkwon.webservice.web;

import com.hbdkwon.webservice.dto.posts.PostsSaveRequestDto;
import com.hbdkwon.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private Environment environment;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Kwon!";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsService.save(dto);
    }

    @GetMapping("/profile")
    public String getProfile() {
        return Arrays.stream(environment.getActiveProfiles())
                .filter(e -> "set1".equals(e) || "set2".equals(e))
                .findFirst()
                .orElse("");
    }
}
