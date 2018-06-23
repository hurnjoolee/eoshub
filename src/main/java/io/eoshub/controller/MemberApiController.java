package io.eoshub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.eoshub.common.CommonResponseModel;
import io.eoshub.common.Constants;
import io.eoshub.model.Member;
import io.eoshub.service.MemberService;
import io.eoshub.type.ResultCodeType;

@Controller
@RequestMapping(value = Constants.API + "/members")
public class MemberApiController extends CommonController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody CommonResponseModel<Member> getMember(@PathVariable String id) {
		return response(ResultCodeType.SUCCESS, memberService.getMember(id));
	}

}
