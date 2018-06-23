package io.eoshub.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import io.eoshub.model.Member;

@Repository
public interface MemberMapper {

	Member getMember(@Param("id") String id);

}
