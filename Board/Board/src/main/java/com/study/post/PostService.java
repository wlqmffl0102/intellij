package com.study.post;

import com.study.common.dto.SearchDto;
import com.study.paging.Pagination;
import com.study.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

     @Transactional
    public long savePost(final PostRequest params){
         postMapper.save(params);
         return params.getId();
     }

    public PostRespone findPostById(final long id){
         return postMapper.findById(id);
     }

     @Transactional
    public Long updatePost(final PostRequest params){
         postMapper.update(params);
         return params.getId();
     }

     public Long deletePost(final long id){
         postMapper.deleteById(id);
         return id;
     }

     public PagingResponse<PostRespone> findAllPost(final SearchDto params){
         int count = postMapper.countAll(params);
         if(count <1){
             return new PagingResponse<>(Collections.emptyList(), null);
         }
         Pagination pagination = new Pagination(count, params);
         params.setPagination(pagination);
         List<PostRespone> list = postMapper.findAll(params);
         return new PagingResponse<>(list, pagination);
    }
}
