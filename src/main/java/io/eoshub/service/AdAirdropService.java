package io.eoshub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.eoshub.mapper.AdAirdropMapper;
import io.eoshub.model.AdAirdrop;

@Transactional
@Service
public class AdAirdropService {

	@Autowired
	private AdAirdropMapper adAirdropMapper;

	public Integer insertAdAirdrop(AdAirdrop adAirdrop) {
		adAirdropMapper.insertAdAirdrop(adAirdrop);

		return adAirdrop.getId();
	}

	public AdAirdrop getAdAirdrop(Integer id) {
		return adAirdropMapper.getAdAirdrop(id);
	}
}
