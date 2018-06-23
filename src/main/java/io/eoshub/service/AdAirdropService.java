package io.eoshub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.eoshub.common.Constants;
import io.eoshub.mapper.AdAirdropMapper;
import io.eoshub.model.AdAirdrop;
import io.eoshub.model.File;
import io.eoshub.type.FileCategoryType;

@Transactional
@Service
public class AdAirdropService {

	@Autowired
	private FileService fileService;

	@Autowired
	private AdAirdropMapper adAirdropMapper;

	public Integer insertAdAirdrop(AdAirdrop adAirdrop) {
		if (adAirdrop == null) {
			return null;
		}

		// file upload
		if (adAirdrop.getIcon() != null && adAirdrop.getIcon().getUploadFile() != null) {
			File file = fileService.insertFile(adAirdrop.getIcon().getUploadFile(), FileCategoryType.AD_AIRDROP);
			adAirdrop.getIcon().setId(file.getId());
		}
		adAirdropMapper.insertAdAirdrop(adAirdrop);

		return adAirdrop.getId();
	}

	public AdAirdrop getAdAirdrop(Integer id) {
		AdAirdrop adAirdrop = adAirdropMapper.getAdAirdrop(id);
		if (adAirdrop != null && adAirdrop.getIcon() != null) {
			adAirdrop.getIcon()
					.setDownloadUrl(Constants.SERVER_URL + "/ad-airdrops/download-icon/" + adAirdrop.getIcon().getId());
		}

		return adAirdrop;
	}

}
