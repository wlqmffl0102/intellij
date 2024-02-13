package com.study.post;

import com.study.common.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void save(PostRequest params);
    PostRespone findById(Long id);
    void update(PostRequest params);
    void deleteById(Long id);
    List<PostRespone> findAll(SearchDto params);
    int countAll(SearchDto params);

}
