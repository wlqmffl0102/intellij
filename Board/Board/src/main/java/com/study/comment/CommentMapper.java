package com.study.comment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void save(CommentRequest params);
    CommentResponse findById(Long id);
    void update(CommentRequest params);
    void deleteById(Long id);
    List<CommentResponse> findAll(CommentSearchDto params);
    int countAll(CommentSearchDto params);
}
