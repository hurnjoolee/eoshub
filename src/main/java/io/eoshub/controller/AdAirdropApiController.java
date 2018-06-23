package io.eoshub.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
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
import io.eoshub.service.FileService;
import io.eoshub.type.FileCategoryType;
import io.eoshub.type.ResultCodeType;

@Controller
@RequestMapping(value = Constants.API + "/ad-airdrops")
public class AdAirdropApiController extends CommonController {

	@Autowired
	private AdAirdropService adAirdropService;

	private FileService fileService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CommonResponseModel<AdAirdrop> insertAdAirdrop(@ModelAttribute AdAirdrop adAirdrop) {
		Integer id = adAirdropService.insertAdAirdrop(adAirdrop);
		return response(ResultCodeType.SUCCESS, adAirdropService.getAdAirdrop(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody CommonResponseModel<AdAirdrop> getAdAirdrop(@PathVariable Integer id) {
		return response(ResultCodeType.SUCCESS, adAirdropService.getAdAirdrop(id));
	}

	@RequestMapping(value = "/download-icon/{id}", method = RequestMethod.GET)
	public @ResponseBody void downloadIcon(HttpServletResponse response, @PathVariable Integer id) {
		InputStream is = null;
		try {
			is = new FileInputStream(new File(fileService.getFilePath(FileCategoryType.AD_AIRDROP, id)));
			IOUtils.copy(is, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

}
