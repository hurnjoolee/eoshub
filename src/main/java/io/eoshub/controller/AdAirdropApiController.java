package io.eoshub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.eoshub.common.CommonResponseModel;
import io.eoshub.common.Constants;
import io.eoshub.model.AdAirdrop;
import io.eoshub.service.AdAirdropService;
import io.eoshub.type.ResultCodeType;

@Controller
@RequestMapping(value = Constants.API + "/ad-airdrops")
public class AdAirdropApiController extends CommonController {

	@Autowired
	private AdAirdropService adAirdropService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CommonResponseModel<AdAirdrop> insertAdAirdrop(@ModelAttribute AdAirdrop adAirdrop) {
		Integer id = adAirdropService.insertAdAirdrop(adAirdrop);
		return response(ResultCodeType.SUCCESS, adAirdropService.getAdAirdrop(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody CommonResponseModel<AdAirdrop> getAdAirdrop(@PathVariable Integer id) {
		return response(ResultCodeType.SUCCESS, adAirdropService.getAdAirdrop(id));
	}

}
