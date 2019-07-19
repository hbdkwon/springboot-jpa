package com.hbdkwon.webservice.dto.posts;

import com.hbdkwon.webservice.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsMainResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;

    public PostsMainResponseDto(Posts posts) {
        id = posts.getId();
        title = posts.getTitle();
        content = posts.getContent();
        author = posts.getAuthor();
        modifiedDate = toStringDateTime(posts.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(dateTimeFormatter::format)
                .orElse("");
    }
}
