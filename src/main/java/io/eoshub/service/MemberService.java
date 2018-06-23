package io.eoshub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.eoshub.mapper.MemberMapper;
import io.eoshub.model.Member;

@Transactional
@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;

	public Member getMember(String id) {
		return memberMapper.getMember(id);
	}
}
