package com.study.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void save(MemberRequest params);
    MemberResponse findByLoginId(String loginId);
    void update(MemberRequest params);
    void deleteById(Long id);
    int countByLoginId(String loginId);
}
