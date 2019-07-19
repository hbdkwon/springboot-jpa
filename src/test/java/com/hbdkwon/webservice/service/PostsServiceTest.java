package com.hbdkwon.webservice.service;

import com.hbdkwon.webservice.domain.Posts;
import com.hbdkwon.webservice.domain.PostsRepository;
import com.hbdkwon.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void save() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("Title")
                .content("Content")
                .author("Kyh")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
    }
}