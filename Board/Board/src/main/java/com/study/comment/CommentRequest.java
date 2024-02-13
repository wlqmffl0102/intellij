package com.study.comment;

import lombok.Getter;

@Getter
public class CommentRequest {

     private Long id;
     private Long postId;
     private String content;
     private String writer;
}
